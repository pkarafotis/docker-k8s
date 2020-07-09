# inherit from this image
FROM openjdk:8-jdk-alpine

# copy application artifact into image
COPY target/*.jar /app/demo-app.jar

# documentation only
EXPOSE 5005
EXPOSE 8080

# this will be executed every time the container is being brought-up
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=n", "-jar","/app/demo-app.jar"]