package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class OrderConfig {

	/*
	 * @Value("${serviceurl}") private String serviceUrl;
	 * 
	 * public String getServiceUrl() { return serviceUrl; }
	 */

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
