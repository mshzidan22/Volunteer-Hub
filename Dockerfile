FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY pom.xml ./
RUN mvn package

COPY target/*.jar ./

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]