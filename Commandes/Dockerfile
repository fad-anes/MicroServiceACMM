FROM openjdk:11
EXPOSE 8082:8082
ADD target/Commande-0.0.1-SNAPSHOT.jar Commande-docker.jar
ENTRYPOINT ["java", "-jar", "Commande-docker.jar"]
