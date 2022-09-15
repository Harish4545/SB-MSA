package com.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {

	@GetMapping("/user")
	public String sayHelloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin()
	{
		return "Hello Admin";
	}
}
