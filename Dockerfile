
# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:8u212-jdk-slim
# Add Maintainer Info
LABEL maintainer="javalove007@gmail.com"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8083
# The application's jar file (when packaged)
ARG JAR_FILE=target/CrackInterview-0.0.1-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} CrackInterview.jar
# Run the jar file