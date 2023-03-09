#FROM openjdk:19
#ARG JAR_FILE=target/*.jar
#COPY ./target/D-Tube-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 10000
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:19
EXPOSE 10000
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]