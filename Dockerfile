# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code (don't include tests)
COPY src/main/ ./src/main

# Package without tests
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre-alpine AS run
WORKDIR /app

# Copy only the final jar
COPY --from=build /app/target/*-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]