package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.pk.*")
public class JTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(JTechApplication.class, args);
	}
	
	
}
