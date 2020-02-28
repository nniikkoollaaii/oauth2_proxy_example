# Example project protecting microservice application in a kubernetes cluster with ingress controller nginx

## Setup

At first build the backend, frontend and keycloak container. Go to the subfolders and follow the instructions in the readme's.

In the subfolder "kind" is an example to setup up a local "kubernetes in docker" cluster

Push the images to your registry if you want to use a different k8s cluster solution

Then deploy the test application. Follow the instructions in the deployment/readme.md
