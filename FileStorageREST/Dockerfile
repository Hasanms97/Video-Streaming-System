FROM openjdk:19
ARG JAR_FILE=target/*.jar
COPY ./target/FileStorage-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar","/app.jar"]