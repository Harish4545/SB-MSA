package com.training;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.training.filters.MyCustomFilter;

import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*@Bean
	public RouteLocator routes(RouteLocatorBuilder builder)
	{
		return builder.routes()
		.route(p->p.path("/helloservice1/**")
				.filters(f->f.addRequestHeader("Authorization", "Bearer hsgdsajarzxxxxaaa")
				.addResponseHeader("my-response-header", "This is a sample response header"))

				//.uri("http://localhost:8088"))
		        .uri("lb://service1"))
		.route(p->p.path("/helloservice2/**")
				//.uri("http://localhost:8089"))
				.uri("lb://service2"))
				.build();


	} */

	private Logger log = LoggerFactory.getLogger(GatewayServiceApplication.class);
	@Bean
	public GlobalFilter globalFilter()
	{
		return (exchange,chain) ->{

			log.info("First Pre Global Filter");
			log.info(""+exchange.getRequest().getPath());
			log.info(""+exchange.getRequest().getMethod());
			
		
			// call helloservice1

			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("First Post Global Filter");
				log.info(""+new Date());


			}));
		};

	}
}
