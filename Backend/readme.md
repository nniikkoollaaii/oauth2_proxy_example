# Backend

## build image

    mvn package

    docker build -t nniikkoollaaii/oauth2-proxy-example-backend:0.1.0 .

## push image to local registry for kind setup

    docker tag nniikkoollaaii/oauth2-proxy-example-backend:0.1.0 localhost:5000/nniikkoollaaii/oauth2-proxy-example-backend:0.1.0

    docker push localhost:5000/nniikkoollaaii/oauth2-proxy-example-backend:0.1.0

## further links

https://pivotal.io/application-modernization-recipes/security/setting-up-oauth2-resource-server
https://www.devglan.com/spring-security/spring-oauth2-role-based-authorization
