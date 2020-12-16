# Backend

## set correct resource id

set client id of this application in file Oauth2ResourceServerExampleConfiguration.java

## build image

    mvn package -DskipTests

skip tests because test tries to get jwks-uri with self signed certificate, which is not imported in your OS kestore
but I added it to your java keystore in the docker image

    docker build -t nniikkoollaaii/oauth2-proxy-example-backend:0.1.0 .

    docker run --name test --rm -p 8080:8080 nniikkoollaaii/oauth2-proxy-example-backend:0.1.0

## further links
Spring Security Docs https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/htmlsingle/#oauth2-boot-resource-server-authorization

https://pivotal.io/application-modernization-recipes/security/setting-up-oauth2-resource-server
https://www.devglan.com/spring-security/spring-oauth2-role-based-authorization


## test auth token

docker run --rm --name test -p 8080:8080 nniikkoollaaii/oauth2-proxy-example-backend:0.1.0

curl -v -H "Authorization: Bearer <token>" localhost:8080/api/test


get token via client credentials flow


curl -v --insecure https://<domain>:30443/auth/realms/test/protocol/openid-connect/token -d "grant_type=client_credentials&client_id=oauth2_proxy&client_secret=ae935dfc-f622-415a-a4d3-bae9bca82700"