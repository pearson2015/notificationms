FROM openjdk:21
COPY ./target/notificationms-0.0.1-SNAPSHOT.jar /notificationms.jar
CMD ["java", "-jar", "/notificationms.jar"]