#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build
MAINTAINER joelniwogaba

# Add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-app.jar

#execute the application
ENTRYPOINT ["java","-jar","/accounts-app.jar"]
