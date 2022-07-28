package com.oardic.springbootbucket4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootBucket4jExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBucket4jExampleApplication.class, args);
	}
}
