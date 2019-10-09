FROM maven:3.6.0-jdk-8
WORKDIR /usr/src/java-code
COPY . /usr/src/java-code/
RUN mvn package
 
WORKDIR /usr/src/java-app
RUN cp /usr/src/java-code/target/*.jar ./app.jar
EXPOSE 8082

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.6.0/wait /wait
RUN chmod +x /wait

CMD ["/wait", "&&" , "java", "-jar", "app.jar"]