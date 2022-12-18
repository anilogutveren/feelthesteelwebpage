FROM eclipse-temurin:17-jre-focal

RUN apt-get update

# create non-root user
RUN useradd appuser --gid=100 --uid=1337 -m

# copy application to workspace
COPY target/*.jar app.jar

USER appuser

CMD ["java", \
"-XX:+PrintCommandLineFlags", \
"-jar","app.jar"]