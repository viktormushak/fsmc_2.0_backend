FROM openjdk:8-alpine

ADD /target/fsmc-backend-1.0-SNAPSHOT.jar fsmc-backend.jar

CMD ["java","-jar","/fsmc-backend.jar"]
