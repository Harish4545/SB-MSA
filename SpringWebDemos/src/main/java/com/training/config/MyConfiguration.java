package com.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//spring-servlet.xml

@EnableWebMvc
@ComponentScan("com.training")
public class MyConfiguration {

	   
	  public void  configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		  configurer.enable(); }

}
