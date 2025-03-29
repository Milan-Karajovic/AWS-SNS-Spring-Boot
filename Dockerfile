# How to build docker image: docker image build -t spring-boot-aws-sns .
FROM openjdk:17-jdk-alpine
COPY target/spring-boot-aws-sns-0.0.1-SNAPSHOT.jar spring-boot-aws-sns-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-aws-sns-0.0.1-SNAPSHOT.jar"]