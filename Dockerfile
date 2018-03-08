FROM maven:3.5.2-jdk-8

COPY . /pqvp

WORKDIR /pqvp

RUN mvn package

EXPOSE 8080

CMD java -jar /pqvp/target/pqvp-0.0.1-SNAPSHOT.jar
