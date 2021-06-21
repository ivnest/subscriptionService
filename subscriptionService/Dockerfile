FROM openjdk:8
ADD target/subscriptionService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8971
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]