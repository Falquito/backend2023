FROM 19-alpine-jdk
COPY target/joel-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

