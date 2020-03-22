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

    .\kubectl create secret tls test-tls --key ./frontend/certs/key.pem --cert ./frontend/certs/cert.pem -n test

## replace with your domain

replace all <domain> with your domain

and set local hosts file for your ip and this domain

## Identity Provider

### using azure ad

Create an application registration in azure ad
use directory id from overview page as replacement <tenant>

use application id from overview page as replacement for <client id>

add a redirect uri:
https://<domain>:30443/oauth2/callback

create a client secret and use it as replacement for <client secret>


add these roles to the app manifest:
    "appRoles": [
		{
			"allowedMemberTypes": [
				"User"
			],
			"description": "blabla",
			"displayName": "Test-Create-Role",
			"id": "4b7f8410-88da-41e5-b8d5-4df12606dbd4",
			"isEnabled": true,
			"lang": null,
			"origin": "Application",
			"value": "testcreaterole"
		},
		{
			"allowedMemberTypes": [
				"User"
			],
			"description": "blabla",
			"displayName": "Test-Read-Role",
			"id": "4b7f8410-88da-41e5-b8d5-4df12606dbd3",
			"isEnabled": true,
			"lang": null,
			"origin": "Application",
			"value": "testreadrole"
		}
	],



add the user account, you're using to create this app registration, to one of these roles 

Azure Active Directory > Users > your user > Applications 

	.\kubectl apply -f oauth2proxy-azuread

### using keycloak

change registry address of image in keycloak/deployment.yaml

	.\kubectl apply -f keycloak

(subpath "auth" cause default subpath for keycloak)


    .\kubectl apply -f oauth2proxy-keycloak




## deployment of backend, frontend

    .\kubectl apply -f frontend
    .\kubectl apply -f backend
