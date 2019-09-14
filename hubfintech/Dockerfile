FROM java:8-jdk-alpine
COPY ./target/hubfintech-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch hubfintech-1.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","hubfintech-1.0-SNAPSHOT.jar"]