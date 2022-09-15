package com.training.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
	
	@Value("${queue}")
	private String queue;
	
	@Bean
	public ActiveMQQueue getActiveMq()
	{
		return new ActiveMQQueue(queue);
	}

}
