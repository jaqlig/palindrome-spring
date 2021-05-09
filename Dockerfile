FROM openjdk:8
EXPOSE 8080
ADD target/palindrome-0.0.1-SNAPSHOT.jar palindrome-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/palindrome-0.0.1-SNAPSHOT.jar"]