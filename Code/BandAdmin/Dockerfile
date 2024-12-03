FROM openjdk:21-jdk
ARG JAR_FILE=./build/libs/BandAdmin-0.0.1-SNAPSHOT-plain.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8000