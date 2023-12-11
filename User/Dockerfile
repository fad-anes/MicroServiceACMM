FROM openjdk:11
LABEL authors="anes_"
EXPOSE 8091
ADD target/user-0.0.1-SNAPSHOT.jar user-docker.jar
ENTRYPOINT ["java", "-jar","user-docker.jar"]