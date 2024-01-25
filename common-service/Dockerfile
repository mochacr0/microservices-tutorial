# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk as base
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw -Dmaven.test.skip=true dependency:resolve
COPY src src
COPY otel otel
COPY opentelemetry-javaagent.jar ./

FROM base as development
ENV JAVA_TOOL_OPTIONS=-javaagent:./opentelemetry-javaagent.jar
ENV OTEL_JAVAAGENT_CONFIGURATION_FILE=/app/otel/otel-config.properties
EXPOSE 8001
CMD ["./mvnw", "spring-boot:run", "-Dmaven.test.skip=true"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine as production
EXPOSE 8001
COPY --from=build /app/target/gateway-*.jar /gateway.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/common-service.jar"]