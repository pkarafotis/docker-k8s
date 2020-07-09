# Docker demo

A short presentation of basic docker features is included

  * ```simple-run```: Simple container creation/run/connection from command line
  * ```build-and-run```: Creation of a custom image from a dummy Spring Boot Application and 
  orchestration of multiple images with ```docker-compose``` 
  
## simple-run
1. Run an nginx container in the background

```
λ docker run --name my-web-server -p 8080:80 -d nginx
006e8bf8b47edcab167c3cffaba82fb21aa4d01539c37cf71ae5912bf669a82b
```

2. List the container created

```
λ docker container ls | grep my-web-server
006e8bf8b47e nginx "/docker-entrypoint.…" 3 minutes ago Up 3 minutes 0.0.0.0:8080->80/tcp my-web-server
```

3. Connect to the running container

```
λ docker exec --it my-web-server bash
```

## build-and-run
1. Start a local registry that will host the produced docker image
```
docker run -d -p 5000:5000 --name registry registry:2 
```

2. Start a container offering a web-ui for visualizing the local docker images
```
docker run -d -p 8088:80 --name registry-ui -e REGISTRY_HOST=host.docker.internal:5000 jc21/registry-ui
```

3. Build the demo-app
```
[demo-app] λ mvn clean install -DskipTests
```

4. Produce a local image for demo-app
```
[demo-app] λ docker build -t localhost:5000/demo-app:1.0.0 .
```

5. Push the produced image to local registry
```
[demo-app] λ docker build -t localhost:5000/demo-app:1.0.0 .
```

6. Bring up nginx, demo-app from docker-compose
```
[build-and-run] docker-compose up -d
```

7. Access the application through nginx exposed port
```
http://localhost:8080
```