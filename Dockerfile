FROM maven:3.9.6-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM jdk-17
COPY --from build /target/Excel-Data-Analyzer-0.0.1-SNAPSHOT.jar Excel-Data-Analyzer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Excel-Data-Analyzer.jar"]