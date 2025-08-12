package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExpiryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpiryProductApplication.class, args);
	}

}