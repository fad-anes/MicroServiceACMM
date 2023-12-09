FROM openjdk:11
LABEL authors="anes_"
EXPOSE 8082
ADD target/Eureka-0.0.1-SNAPSHOT.jar Eureka-docker.jar
ENTRYPOINT ["java", "-jar","Eureka-docker.jar"]