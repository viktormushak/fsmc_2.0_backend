FROM openjdk:8-alpine

ADD /target/fsmc-backend-1.0-SNAPSHOT.jar fsmc-backend.jar

CMD ["java", "-Dspring.profiles.active=prod", "-jar", "/fsmc-backend.jar"]
