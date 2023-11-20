FROM maven:3.6.3-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvnw -f /home/app/pom.xml clean package

#
# Package stage
#
FROM maven:3.6.3-jdk-8-slim
COPY --from=build /home/app/target/*.jar  /usr/local/lib/volunteer-hub.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/volunteer-hub.jar"]