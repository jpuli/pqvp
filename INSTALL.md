# Deployment Instructions (Development)

## Dependencies

* Github access to check out this project
* A computer with Docker version **17.12.0-ce** installed (See [installation instructions mac](https://docs.docker.com/docker-for-mac/install/), [instructions for windows](https://docs.docker.com/docker-for-windows/install/), or [for linux](https://docs.docker.com/install/linux/docker-ce/ubuntu/))
  * Note: these instructions were tested on Linux and Mac OSX
* A computer with Docker Compose version docker-compose version **1.18.0** installed (See [installation instructions]())

## Setup

* Clone this repo

  $ git clone https://github.com/jpuli/pqvp.git

* Open command line propmt in *pqvp* directory
* Build and start service, docker-compose will download dependencies, build, and start the service in the foreground listening on port 80

  $ docker-compose up

* Wait for log out put to print **Daas Application Ready**
* Open browser to http://localhost

## Basic Development Workflow

The docker-compose.yml file included in this project sets up two volumes for development use. First it mounts the
current directory as a volume in the container under */pqvp* the project root in the container. Second it creates
a named volume (*mavendeps*) to be mounted under */root/.m2* so that maven project dependencies need only be
downloaded once, instead of each time the project is built.

* Modify code / tests
* Clean and rebuild the jar package for the project

  $ docker-compose run --rm pqvp mvn clean package

* Restart container

  $ docker-compose restart pqvp

* Reattach to logs as needed

  $ docker-compose logs -f pqvp

* Run only the compile and test phases of the project

  $ docker-compose run --rm pqvp mvn test

# Deployment Instructions (Production)

## Dependencies

* A linux server with Docker version **17.12.0-ce** installed (See [See Gnu/Linux Installation Instructions](https://docs.docker.com/install/linux/docker-ce/ubuntu/))
  * Note: these instructions were tested on Amazon Linux AMI Version 2017.09 image running in AWS

## Deploy

Currently this project is deployed by the **Deploy** stage of the *Jenkinsfile* we have. It builds the project
docker image and then deploys that image to a server running a docker service. Normally built images would be
deployed to a docker registry such as DockerHub for easy management and deployment. However, for this project
we simply export the built image from jenkins host and load it on in the deploy server before starting it.

* Build the image

  $ docker build -t pqvp:tagName

* Deploy image

  $ docker save -o pqvp-tagName.img pqvp:tagName
  $ scp pqvp-tagName.img deployUser@deployServer:~/*
  $ ssh deployUser@deployServer docker load -i pqvp-tagName.img
  $ ssh deployUser@deployServer docker stop pqvp # if running

* Start container based on tagged image

  $ ssh deployUser@deployServer docker run --rm -d -p 80:8080 --name pqvp pqvp:${shortCommit}

* Once deployed browse to http://your.server.name.example.com to use application
