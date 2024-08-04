# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
COPY target/*.jar app.jar

ENV PORT 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
