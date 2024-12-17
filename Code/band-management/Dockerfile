FROM gradle:8.11.1-jdk21 AS build

WORKDIR /band-management
COPY /band-management/src/main/resources/application.properties .
RUN gradle build --no-daemon

FROM openjdk:21-jdk

COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080
