package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.TestConfig;

@RestController
public class TestController {

	@Autowired
	private TestConfig testConfig;
	
	@GetMapping("/message")
	public String getMessage()
	{
		return testConfig.getMessage();
	}
}
