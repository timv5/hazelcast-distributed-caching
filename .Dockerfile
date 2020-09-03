FROM maven:3.6-jdk-11 as maven_build

WORKDIR /app
COPY . /app
RUN mvn clean install -Dmaven.test.skip

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=maven_build app/target/hazelcast-distributed-caching-1.0-SNAPSHOT.jar hazelcast-distributed-caching-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","hazelcast-distributed-caching-1.0-SNAPSHOT.jar"]