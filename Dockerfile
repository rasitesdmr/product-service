FROM openjdk:17
EXPOSE 9090
ADD target/product-service.jar. product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]