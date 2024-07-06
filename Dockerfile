FROM openjdk:17
LABEL maintainer="Ashutosh Satapathy"
EXPOSE 8080
VOLUME /tmp
COPY build/libs/bank-property-evaluator-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
