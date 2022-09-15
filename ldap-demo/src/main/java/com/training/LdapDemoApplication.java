package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LdapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdapDemoApplication.class, args);
	}

	@GetMapping
	public String sayHelloLdap()
	{
		return "Spring Secuity with LDAP";
	}
}
