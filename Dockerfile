FROM gradle:jdk21-jammy as builder
WORKDIR /project
COPY *.gradle /project/
RUN gradle clean dependencies
COPY . .
RUN gradle bootJar

FROM openjdk:21-slim
COPY --from=builder /project/build/libs/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]