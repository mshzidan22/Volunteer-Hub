# Use an OpenJDK 8 runtime as a base image
FROM openjdk:8-jre-alpine
# Set the working directory in the container
WORKDIR /app
# Copy the JAR file into the container
COPY target/*.jar /app/volunteer-hub.jar
# Expose the port that your Spring Boot application will run on
EXPOSE 8080
# Specify the default command to run your application
CMD ["java", "-jar", "volunteer-hub.jar"]