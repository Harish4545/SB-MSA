package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.bean.AddOperator;
import com.training.bean.MultiplyOperator;
import com.training.bean.OperatorDemo;
import com.training.interfaces.Operator;

//@Configuration
public class MyConfiguration {

	@Bean("add")
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	  @Bean("multiply") public Operator getOperator1() { return new
	  MultiplyOperator(); }
	 
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		return new OperatorDemo(getOperator());
	}
}
