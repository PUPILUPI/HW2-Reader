FROM openjdk:18.0.2-jdk-slim

ARG JAR_FILE=ReactorLibrary-1.0-SNAPSHOT-jar-with-dependencies.jar

WORKDIR /opt/app

COPY ${JAR_FILE} ReactorLibrary.jar

ENV DISPLAY=:0

ENTRYPOINT ["java", "-jar","ReactorLibrary.jar"]

