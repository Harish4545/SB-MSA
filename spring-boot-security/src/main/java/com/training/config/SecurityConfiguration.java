package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		log.info("In Authentication");
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password("{noop}user123")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("{noop}admin123")
		.roles("ADMIN");
		
	}
	
	//Authorization
	
	public void configure(HttpSecurity http) throws Exception
	{
		log.info("In Authorization");
		http
		.authorizeRequests()
		.antMatchers("/user/**")
		.hasRole("USER")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and()
		.formLogin();
		
	}
	

}
