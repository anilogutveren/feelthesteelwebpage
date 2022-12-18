FROM eclipse-temurin:17-jre-focal

RUN apt-get update

# create non-root user
RUN useradd appuser --gid=100 --uid=1337 -m

# copy application to workspace
COPY target/*.jar /var/opt/app.jar

USER appuser

CMD ["java", \
"-XX:MaxRAMPercentage=75", \
"-XX:+PrintCommandLineFlags", \
"-jar","/var/opt/app.jar"]