# KIND

### start kind cluster

    kind create cluster --config kind-cluster.yaml

    kind load docker-image quay.io/kubernetes-ingress-controller/nginx-ingress-controller:0.29.0
    .\kubectl apply -f ingress

and

    curl -v http://localhost:30080/test

should show 404

Kind cannot detect your docker images in your local docker registry
you can setup a docker registry in a docker container
or import the images manually with these commands

    kind load docker-image nniikkoollaaii/oauth2-proxy-example-keycloak:0.5.0
    kind load docker-image nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0
    kind load docker-image nniikkoollaaii/oauth2-proxy-example-backend:0.1.0
    kind load docker-image quay.io/pusher/oauth2_proxy:v5.0.0

## further links

https://github.com/kubernetes-sigs/kind/issues/758
https://banzaicloud.com/blog/kind-ingress/

### delete kind cluster

    kind delete cluster
