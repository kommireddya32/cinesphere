# Stage 1: Build the application using Maven with Java 21
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight image using a Java 21 JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# This line copies the .jar file, which is correct for this project
COPY --from=build /app/target/cinesphere-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]