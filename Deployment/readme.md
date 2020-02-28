# Deployment

## create namespace

    .\kubectl apply -f ns.yaml

## deployment information

propaply you have to add your registry's address in the image
and change your ingress host

## generate certs

    docker run -it --name openssl --rm --workdir "/app" --entrypoint /bin/sh -d frapsoft/openssl

    docker exec -it openssl /bin/sh -c "openssl req -x509 -nodes -newkey rsa:2048 -keyout key.pem -out cert.pem -days 365 -subj '/CN=<domain>/O=<domain>'"

    docker cp openssl:/app/. ./frontend/certs

    kubectl create secret tls test-tls --key ./frontend/certs/key.pem --cert ./frontend/certs/cert.pem -n test

## replace with your domain

replace all <domain> with your domain

and set local hosts file for your ip and this domain

## deployment of keycloak

change registry address of image in keycloak/deployment.yaml

    .\kubectl apply -f keycloak

your keycloak instance is reachable at https://localhost:30443/auth with kind
(subpath "auth" cause default subpath for keycloak)

## deployment of backend, frontend and oauth2_proxy

    .\kubectl apply -f frontend
    .\kubectl apply -f backend
    .\kubectl apply -f oauth2proxy
