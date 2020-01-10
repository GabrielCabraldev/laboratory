FROM java:8-jdk-alpine
COPY ./target/timesheet-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch timesheet-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","timesheet-0.0.1-SNAPSHOT.jar"]