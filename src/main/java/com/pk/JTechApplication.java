package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@ComponentScan(basePackages="com.pk.*")
@TestPropertySource(properties = "debug=true")
public class JTechApplication {

	public static void main(String[] args) {
		log.info("Application started");
		SpringApplication.run(JTechApplication.class, args);
	}
	
	
}
