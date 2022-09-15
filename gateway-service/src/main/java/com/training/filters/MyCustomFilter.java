package com.training.filters;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class MyCustomFilter extends AbstractGatewayFilterFactory<MyCustomFilter.Config> {
	
	private Logger log = LoggerFactory.getLogger(MyCustomFilter.class);
	public static class Config
	{
		
	}

	public MyCustomFilter()
	{
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange,chain) ->{
			
			log.info("First Pre Filter");
			log.info(""+exchange.getRequest().getPath());
			log.info(""+exchange.getRequest().getMethod());
			// call helloservice1
			
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("First Post Filter");
				log.info(""+new Date());
				
				
			}));
		};
		
		
	}

}
