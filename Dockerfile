FROM openjdk
LABEL maintaner = 'abc@mail.com'
EXPOSE 8082
WORKDIR /app
COPY target/student-service.jar /app/student-service.jar
ENTRYPOINT ["java","-jar","student-service.jar"]