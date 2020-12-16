# Generate Certificate

OAuth2's authorization code flow should only go over https (and some IP's like keycloak don't allow without)

If you don't have an installation of openssl use this docker image

    docker run -it --name openssl --rm --workdir "/app" --entrypoint /bin/sh -d frapsoft/openssl

Credit to https://deliciousbrains.com/ssl-certificate-authority-for-local-https-development/

## generate CA

create private key for CA

    openssl genrsa -out ca.key 2048


create self signed certificate for CA
only Common Name matters -> set something your recogniza as your CA

    openssl req -x509 -new -nodes -key ca.key -sha256 -days 1825 -out ca.pem

## generate App Cert

modify config file openssl.conf
copy to docker container
    
    docker cp openssl.conf openssl:/app/openssl.conf

generate app private key 

    openssl genrsa -out app.key 2048

and certificate signing request via

    openssl req -new -out app.csr -key app.key -config openssl.conf

sign the csr

    openssl x509 -req -in app.csr -CA ca.pem -CAkey ca.key -CAcreateserial -out app.crt


you can verify your certificate via

    openssl verify -CAfile ca.pem app.crt

## Copy files


    docker cp openssl:/app/ .












	ToDo: 
	Certificate einbinden in Keystore von Backend Image
	https://stackoverflow.com/questions/41497871/importing-self-signed-cert-into-dockers-jre-cacert-is-not-recognized-by-the-ser






