FROM bitnami/minideb:latest
USER 0

RUN apt-get update \
	&& apt-get upgrade -y \
	&& apt-get install -y openjdk-17-jre-headless \

ADD service/target/integration-service-0.0.1.jar /integration-service.jar
ADD order-integration.csv /order-integration.csv
RUN "env"
RUN "pwd"
RUN "ls"
EXPOSE 8080
ENTRYPOINT ["java","-XX:InitialRAMPercentage=60","-XX:MaxRAMPercentage=60","-jar","/integration-service.jar"]
