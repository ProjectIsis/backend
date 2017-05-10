# Oauth2 Server

Run this project as a Spring Boot app, e.g. import into IDE and run
main method, or use Maven:

```
$ ./mvnw spring-boot:run
```

or

```
$ ./mvnw package
$ java -jar target/*.jar
```

## Pre-requisites
Mysql<br>
Api-Gateway

## Resources

| Path             | Description  |
|------------------|--------------|
| POST /oauth/token | Request token |
| GET  /user | Returns a principal user |
| POST /user | Register new user |
| POST /user/password?passwordAnt=&passwordNew=&passwordConfirm= | Update password |