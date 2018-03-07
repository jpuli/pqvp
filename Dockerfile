FROM maven:3.5.2-jdk-8

COPY . /pqvp

WORKDIR /pqvp

RUN mvn install

