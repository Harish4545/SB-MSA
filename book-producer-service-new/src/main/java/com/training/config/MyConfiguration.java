package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.interfaces.ConfigurationProcessor;


@ConfigurationProperties("number")
@Configuration
public class MyConfiguration  {

	@Value("${message}")
	private String message;

	public String getMessage() {
		return message;
	}
	
	
	private String start;
	private String endValue;
	
	public void setStartValue(String start) {
		this.start = start;
	}

	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	public String getStartValue() {
		return start;
	}

	public String getEndValue() {
		return endValue;
	}

	
	


	
	
}
