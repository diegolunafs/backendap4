FROM amazoncorretto:11-alpine-jdk
MAINTAINER DiegoLuna
COPY target/DL-0.0.1-SNAPSHOT.jar dlportfolio-app.jar
ENTRYPOINT ["java","-jar","/dlportfolio-app.jar"]
