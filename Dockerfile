# --- Giai đoạn 1: Build ứng dụng ---
FROM eclipse-temurin:22-jdk AS build
WORKDIR /app

# Copy file Maven config và source code
COPY pom.xml .
COPY src ./src

# Cài Maven và build project
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# --- Giai đoạn 2: Chạy ứng dụng ---
FROM eclipse-temurin:22-jre
WORKDIR /app

# Copy file .jar từ giai đoạn build
COPY --from=build /app/target/*.jar app.jar

# Copy file .env từ thư mục resources
COPY src/main/resources/.env .env


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
