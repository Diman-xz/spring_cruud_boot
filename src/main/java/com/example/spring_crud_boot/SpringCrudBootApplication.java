package com.example.spring_crud_boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.example.spring_crud_boot")
public class SpringCrudBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudBootApplication.class, args);
	}
}

