package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootSslDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslDemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello()
	{
		return "This is SSL Enabled";
	}
}
