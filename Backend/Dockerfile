FROM adoptopenjdk:8-jre-openj9

RUN mkdir app

COPY ./target/backend*.jar app/app.jar

EXPOSE 8080

ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
