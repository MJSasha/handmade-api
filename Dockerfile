FROM openjdk:11
EXPOSE 8080
ADD target/houses-api.jar houses-api.jar
ENTRYPOINT ["java", "-jar", "/houses-api.jar"]