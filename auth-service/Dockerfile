FROM openjdk:22

WORKDIR /app

COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar

COPY .env .env

ENTRYPOINT ["java", "-Dserver.port=0", "-jar", "app.jar"]
