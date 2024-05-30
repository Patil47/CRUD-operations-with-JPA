package com.ospl.__product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(Application.class, args);
	}
}

// Modification in Service Layer
// Implementing ResponseEntity
// Implementing Http Status
// Database connectivity
// Jpa
// property files (.yml)
// Custom Repository methods