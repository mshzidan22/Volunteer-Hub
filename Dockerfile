FROM maven:3.8.2-jdk-8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests
FROM openjdk:8-jdk-slim
COPY --from=build /target/app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]