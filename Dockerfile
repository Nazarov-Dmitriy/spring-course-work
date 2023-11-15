FROM openjdk:17-alpine

EXPOSE 5500

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} coursework.jar

ENTRYPOINT  ["java", "-jar", "/coursework.jar"]