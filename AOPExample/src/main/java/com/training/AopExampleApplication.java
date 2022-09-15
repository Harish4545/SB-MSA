package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.services.MyService;

@SpringBootApplication
public class AopExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopExampleApplication.class, args);
	}

	@Autowired
	private MyService service;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			System.out.println(service.getName("sam"));
			
		//	System.out.println(service.getSalary());
		
			
			
		};
	}
}
