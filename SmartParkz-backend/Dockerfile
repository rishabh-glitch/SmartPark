FROM openjdk:17-oracle
COPY target/*.jar demo.jar 
RUN chmod +x ./mvnw
RUN ./mvnw clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]