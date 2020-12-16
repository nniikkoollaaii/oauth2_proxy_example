kind create cluster --config kind-cluster.yaml
kind load docker-image quay.io/kubernetes-ingress-controller/nginx-ingress-controller:0.29.0
.\kubectl apply -f ingress
kind load docker-image nniikkoollaaii/oauth2-proxy-example-keycloak:0.5.0
kind load docker-image nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0
kind load docker-image nniikkoollaaii/oauth2-proxy-example-backend:0.1.0
kind load docker-image quay.io/pusher/oauth2_proxy:v5.0.0



