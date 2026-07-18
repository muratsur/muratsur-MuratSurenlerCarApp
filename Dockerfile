FROM maven:3.9-eclipse-temurin-8 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn -Dmaven.test.skip=true clean package

FROM eclipse-temurin:8-jre
WORKDIR /app

COPY --from=build /app/target/*.war app.war

EXPOSE 8080
CMD ["java", "-jar", "app.war"]
