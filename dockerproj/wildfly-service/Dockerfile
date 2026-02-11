FROM eclipse-temurin:17-jre-alpine
ENV WILDFLYHOME=/opt/jboss/wildfly

RUN mkdir -p $WILDFLYHOME

COPY ./wildfly $WILDFLYHOME

COPY deployments/ $WILDFLYHOME/standalone/deployments/

EXPOSE 1337

CMD [ "/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagment", "0.0.0.0"]
