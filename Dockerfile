# Stage 1: Build the app with Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (for caching)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the app and package it as a fat jar
RUN mvn clean package -DskipTests

# Stage 2: Run the app with a lightweight JRE image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Copy .env file for dotenv-java if needed
COPY .env /app/.env

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
