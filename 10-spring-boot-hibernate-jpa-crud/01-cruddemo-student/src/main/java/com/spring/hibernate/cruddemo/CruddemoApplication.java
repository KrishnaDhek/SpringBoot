package com.spring.hibernate.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean

	// CommandLineRunner bean to execute code when the application starts
	public CommandLineRunner commandLineRunner(String[] args){
	return runner->{
		// Code to be executed when the application starts
		System.out.println("Hello World");
	};
	}
}
