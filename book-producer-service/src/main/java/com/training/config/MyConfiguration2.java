package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.interfaces.ConfigurationProcessor;


//@Profile("test")
@ConfigurationProperties("number")
@Configuration
public class MyConfiguration2 implements ConfigurationProcessor{

	@Value("${message}")
	private String message;

	public void process() {
		System.out.println("This is in test mode");
		System.out.println(message);
	}
	
	
	
	
}
