FROM java:8-jdk-alpine
COPY ./target/guia-dogs-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch guia-dogs-1.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","guia-dogs-1.0-SNAPSHOT.jar"]