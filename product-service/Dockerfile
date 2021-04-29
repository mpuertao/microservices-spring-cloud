FROM openjdk:11
COPY "./build/libs/product-service-0.0.1-SNAPSHOT.jar" "app-product.jar"
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app-product.jar"]