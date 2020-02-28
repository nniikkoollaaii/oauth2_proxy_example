FROM jboss/keycloak:3.4.3.Final

USER root

ADD config.template /opt/jboss/keycloak/
RUN chmod 777 /opt/jboss/keycloak/config.template
ADD docker-entrypoint.sh /opt/jboss/
RUN chmod 777 /opt/jboss/docker-entrypoint.sh

USER jboss

ENTRYPOINT [ "/opt/jboss/docker-entrypoint.sh" ]

