package com.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Order;
import com.training.services.OrderServiceFeign;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OrderServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceFeignApplication.class, args);
	}

	
	@Autowired
	private OrderServiceFeign orderService;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
		//	System.out.println(orderService.createOrder1(new Order(6532l, "sample", 100.20, 100l, 12, 12.5)));
		};
	}
}
