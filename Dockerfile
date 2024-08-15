FROM openjdk:17
COPY ./target/notificationms.jar /notificationms.jar
CMD ["java", "-jar", "/notificationms.jar"]