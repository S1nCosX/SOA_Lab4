FROM eclipse-temurin:11-jre-jammy

ENV MULE_VERSION=4.6.0
ENV MULE_HOME=/opt/mule

RUN apt-get update && \
    apt-get install -y unzip && \
    rm -rf /var/lib/apt/lists/*

COPY mule-standalone-4.6.0.zip /tmp/mule.zip

RUN unzip /tmp/mule.zip -d /opt \
    && mv /opt/mule-standalone-${MULE_VERSION} ${MULE_HOME} \
    && rm /tmp/mule.zip

WORKDIR ${MULE_HOME}

VOLUME ["${MULE_HOME}/apps"]

EXPOSE 8080

CMD ["./bin/mule"]
