FROM eclipse-temurin:25-jre-alpine
RUN apk upgrade
RUN apk add bash wget
COPY target/ms-*.jar ms.jar
RUN wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

ARG GITHUB_REF_NAME
ARG CMD_DEVELOP='java -jar ms.jar'
ARG CMD_PRODUCTION='java -Dcom.sun.management.jmxremote -javaagent:dd-java-agent.jar -Ddd.profiling.enabled=true -jar ms.jar'

RUN bash -c "if [ '$GITHUB_REF_NAME' == 'master' ] || [ '$GITHUB_REF_NAME' == 'main' ]  ; then echo $CMD_PRODUCTION > run.sh; else echo $CMD_DEVELOP > run.sh; fi; chmod 500 run.sh;"
RUN cat run.sh

EXPOSE 8080

CMD ./run.sh
