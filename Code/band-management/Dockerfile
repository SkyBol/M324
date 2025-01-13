FROM gradle:8.11.1-jdk21 AS build

WORKDIR /band-management
COPY . .
RUN gradle build --no-daemon

FROM openjdk:21-jdk

COPY --from=build /band-management/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080
