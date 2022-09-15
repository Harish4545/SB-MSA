package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping
	public String sayHello()
	{
		return "Welcome to Spring Security";
	}
	
	@GetMapping("user/hello")
	public String helloUser()
	{
		return "Hello User!";
	}
	
	@GetMapping("admin/hello")
	public String helloAdmin()
	{
		return "Hello Admin!";
	}
	
}
