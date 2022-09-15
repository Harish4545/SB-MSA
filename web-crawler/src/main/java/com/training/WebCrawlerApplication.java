package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.services.CrawlerService;

@SpringBootApplication
public class WebCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
	
	@Autowired
	private CrawlerService crawlerService;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			crawlerService.crawlMovies();
		};
	}

}
