FROM adoptopenjdk:8-jre-openj9

RUN mkdir app

COPY ./target/backend*.jar app/app.jar

COPY ./cert/ca.pem /ca.pem
RUN cd $JAVA_HOME/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias oauth2-proxy -file /ca.pem


EXPOSE 8080

ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
