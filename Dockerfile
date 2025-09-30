# Stage 1: Build the application using Maven with Java 21
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight image using a Java 21 JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# This line now uses a wildcard to find the JAR file
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]