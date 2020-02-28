# Frontend

## build image

    npm install

    npm run build

    docker build -t nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0 .

## push image to local registry for kind setup

    docker tag nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0 localhost:5000/nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0

    docker push localhost:5000/nniikkoollaaii/oauth2-proxy-example-frontend:0.1.0
