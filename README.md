# Spring Boot Bucket4j Example for IP-Based Rate-Limiting

An example Spring Boot project which uses `Bucket4j` rate-limiting library for IP-based rate-limiting.

### How to Run
Start the application with the command `mvn spring-boot:run` and test the following endpoints for rate-limiting:

* http://localhost:8080/first - 1 req / 5 sec
* http://localhost:8080/second - 2 req / 5 sec