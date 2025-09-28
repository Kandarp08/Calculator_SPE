# Stage 1: Build the application
FROM maven:3.9.9-amazoncorretto-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml ./

# Copy the entire project source code
COPY ./src /app/src

# Package the application
RUN mvn clean install -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim AS run

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar ./app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]