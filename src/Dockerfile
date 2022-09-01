FROM eclipse-temurin:17-jre-focal

RUN apt-get update

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

COPY target/*.jar /var/opt/app.jar

RUN javac Main.java
CMD ["java", "Main"]