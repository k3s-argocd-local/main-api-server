FROM eclipse-temurin:17-jre
WORKDIR /app

RUN addgroup --system spring && adduser --system spring --ingroup spring

COPY build/libs/*SNAPSHOT.jar app.jar
RUN chown spring:spring app.jar

USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
