FROM eclipse-temurin:25.0.2_10-jdk-alpine@sha256:d3f9f60ad2040582239e2977ee753d598787d8b064ca39a8e131860165dd81fb

ARG BUILD_DATE
ARG VERSION

LABEL org.opencontainers.image.created="$BUILD_DATE"
LABEL org.opencontainers.image.authors="Natural Resource Information and Digital Services"
LABEL org.opencontainers.image.url="https://github.com/bcgov/nr-forest-client-commons/pkgs/container/nr-forest-client-commons%2Fcertextractor"
LABEL org.opencontainers.image.documentation="https://github.com/bcgov/nr-forest-client-commons/wiki"
LABEL org.opencontainers.image.source="https://github.com/bcgov/nr-forest-client-commons"
LABEL org.opencontainers.image.version="$VERSION"
LABEL org.opencontainers.image.licenses="Apache-2.0"
LABEL org.opencontainers.image.title="Oracle Database Client Certificate Extractor"
LABEL org.opencontainers.image.vendor="Government of British Columbia"
LABEL org.opencontainers.image.description="Extracts the Oracle Database Client certificates from the Oracle connection and adds them to the Java Truststore."
LABEL org.opencontainers.image.base.name="eclipse-temurin:17.0.11_9-jdk-alpine"

ENV LANG=en_CA.UTF-8
ENV LANGUAGE=en_CA.UTF-8
ENV LC_ALL=en_CA.UTF-8

WORKDIR /app

RUN apk --no-cache add openssl

COPY startup.sh .

RUN chmod g+w /app && \
    chmod g+x startup.sh && \
    chmod g+w ${JAVA_HOME}/lib/security/cacerts

# Non-privileged user
USER app

ENTRYPOINT ["sh", "startup.sh"]
