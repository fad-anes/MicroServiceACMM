FROM openjdk:17
LABEL authors="anes_"
EXPOSE 9999:9999
ADD target/gateway-0.0.1-SNAPSHOT.jar gateway-docker.jar
ENTRYPOINT ["java", "-jar","gateway-docker.jar"]