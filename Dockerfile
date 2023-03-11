FROM openjdk:17
EXPOSE 9090
ADD target/product-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]