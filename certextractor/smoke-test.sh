#!/usr/bin/env bash
# Smoke test for the certextractor image.
#
# Starts a throwaway TLS server on localhost, runs the image against it and
# checks that the server certificate lands in /cert/jssecacerts. Also checks
# the insecure-port skip and that an existing keystore is left alone.
#
# Usage: certextractor/smoke-test.sh <image>
set -euo pipefail

IMAGE="${1:?usage: $0 <image>}"
CLI="${CONTAINER_CLI:-docker}"
HOST=localhost
PORT=8443
STOREPASS=changeit
# OpenShift runs containers as an arbitrary UID in group 0; do the same
RUN_AS="${RUN_AS:-1000770000:0}"

WORK="$(mktemp -d)"
SERVER_PID=""
cleanup() {
  [ -z "${SERVER_PID}" ] || kill "${SERVER_PID}" 2>/dev/null || true
  rm -rf "${WORK}" 2>/dev/null || true
}
trap cleanup EXIT

fail() {
  echo "FAIL: $*"
  exit 1
}

# Throwaway self-signed certificate; never printed
openssl req -x509 -newkey rsa:2048 -nodes -days 1 -subj "/CN=${HOST}" \
  -keyout "${WORK}/server.key" -out "${WORK}/server.crt" 2>/dev/null
openssl s_server -quiet -www -accept "${PORT}" \
  -cert "${WORK}/server.crt" -key "${WORK}/server.key" >/dev/null 2>&1 &
SERVER_PID=$!
for _ in $(seq 1 20); do
  (echo > "/dev/tcp/127.0.0.1/${PORT}") 2>/dev/null && break
  sleep 0.5
done

mkdir -m 777 "${WORK}/cert"
extract() {
  "${CLI}" run --rm --network host --user "${RUN_AS}" -v "${WORK}/cert:/cert" \
    -e ORACLEDB_HOST="${HOST}" -e ORACLEDB_PORT="$1" -e ORACLEDB_SECRET="${STOREPASS}" \
    "${IMAGE}" 2>&1
}

echo "Case 1: insecure port 1521 is skipped"
out="$(extract 1521)" || fail "container run failed: ${out}"
grep -q "Skipping certificate generation" <<< "${out}" || fail "no skip message: ${out}"
[ ! -e "${WORK}/cert/jssecacerts" ] || fail "keystore created for port 1521"

echo "Case 2: certificate is extracted into the keystore"
out="$(extract "${PORT}")" || fail "container run failed: ${out}"
[ -s "${WORK}/cert/jssecacerts" ] || fail "keystore not created"
want="$(openssl x509 -in "${WORK}/server.crt" -noout -fingerprint -sha256 | cut -d= -f2)"
got="$("${CLI}" run --rm --user "${RUN_AS}" -v "${WORK}/cert:/cert" --entrypoint keytool "${IMAGE}" \
  -list -v -keystore /cert/jssecacerts -storepass "${STOREPASS}" -alias "${HOST}" \
  | sed -n 's/^[[:space:]]*SHA256: //p')"
[ -n "${got}" ] && [ "${got}" = "${want}" ] || fail "fingerprint mismatch (want ${want}, got ${got:-none})"

echo "Case 3: an existing keystore is kept"
before="$(sha256sum "${WORK}/cert/jssecacerts" | cut -d' ' -f1)"
out="$(extract "${PORT}")" || fail "container run failed: ${out}"
grep -q "certificate file is present" <<< "${out}" || fail "existing keystore not detected: ${out}"
after="$(sha256sum "${WORK}/cert/jssecacerts" | cut -d' ' -f1)"
[ "${before}" = "${after}" ] || fail "existing keystore was modified"

echo "PASS: certextractor smoke test"
