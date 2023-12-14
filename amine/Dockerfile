FROM openjdk:17
LABEL authors="anes_"
EXPOSE 8085:8085
ADD target/amine-0.0.1-SNAPSHOT.jar amine-docker.jar
ENTRYPOINT ["java", "-jar","amine-docker.jar"]