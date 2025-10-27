FROM eclipse-temurin:17.0.16_8-jdk-alpine@sha256:eb42bc053cbff0d750d76fa0705b6faec2677131a1358d0bafcc844051b8872c

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
