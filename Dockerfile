FROM eclipse-temurin:17-jre-focal
COPY /target/webpage-1.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","webpage-1.jar"]