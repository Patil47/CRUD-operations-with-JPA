package com.ospl.__employee;

import com.ospl.__employee.dao.EmployeeDao;
import com.ospl.__employee.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = "com/ospl/__employee/controller")
public class Application {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public EmployeeDao getDao(){
		return new EmployeeDao();
	}

	@Bean
	public EmployeeService getService(){
		return new EmployeeService();
	}

}

// Basic CRUD operation project
// DB Connectivity
// Jpa
