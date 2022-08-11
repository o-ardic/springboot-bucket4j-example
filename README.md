# Spring Boot Bucket4j Example for IP-Based Rate-Limiting (3 Alternatives)

An example Spring Boot project which uses `Bucket4j` rate-limiting library for IP-based rate-limiting. It supports 3 
different caching alternatives; Caffeine, Redis and Hazelcast.

### Configuration
* For rate-limiting and caching, edit application.yml file to conform your requirements.
* Dependencies in pom.xml file should be set to enable one of Caffeine, Redis or Hazelcast. All dependencies are already 
included, just uncomment the appropriate section in pom.xml file. 

### How to Run
Start the application with the command `mvn spring-boot:run` and test the following endpoints for rate-limiting:

* http://localhost:8080/first - 1 req / 5 sec
* http://localhost:8080/second - 2 req / 5 sec

### Distributed Rate Limiting
If distributed rate limiting is enabled (Hazelcast or Redis), then you can start the application on different ports and 
see the results. For example, you can start 2 instances with the following commands:

        mvn spring-boot:run -D"spring-boot.run.jvmArguments"='-Dserver.port=8080'
        mvn spring-boot:run -D"spring-boot.run.jvmArguments"='-Dserver.port=8081'

Then test with the following endpoints:

* http://localhost:8080/first - 1 req / 5 sec
* http://localhost:8081/first - 1 req / 5 sec

* http://localhost:8080/second - 2 req / 5 sec
* http://localhost:8081/second - 2 req / 5 sec

The path `/first` will allow only 1 req / 5 sec no matter from which port (8080 or 8081) the page is accessed.

The path `/second` will allow only 2 req / 5 sec no matter from which port (8080 or 8081) the page is accessed.

### Hazelcast:
Hazelcast doesn't need a standalone instance like Redis. Adding the dependencies will be enough to start a Hazelcast 
cluster.

### Redis:
Run the following command to start a Redis instance if you don't have it.

        docker run --name redis -d -p 6379:6379 redis