FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/Excel-Data-Analyzer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", ".jar", "/Excel-Data-Analyzer-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080