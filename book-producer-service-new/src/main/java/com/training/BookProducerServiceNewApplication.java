package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import com.training.config.MyConfiguration;
import com.training.interfaces.ConfigurationProcessor;
import com.training.model.Book;
import com.training.repo.BookRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Book Store API ",version = "2.0", description = "Books Information"))
@SpringBootApplication
public class BookProducerServiceNewApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookProducerServiceNewApplication.class, args);
	}
	
	/*
	 * @Autowired private ConfigurationProcessor config1;
	 * 
	 * @Autowired private MyConfiguration config;
	 */
	/*
	 * @Autowired private BookRepo bookRepo;
	 */
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * System.out.println(config.getMessage());
		 * System.out.println(config.getStartValue());
		 * 
		 * System.out.println(config.getEndValue());
		 * 
		 * config1.process();
		 */
		
	//	System.out.println(bookRepo.findByTitle("CPlus"));
	//	System.out.println(bookRepo.findByTitleLike("%C%"));
	//	System.out.println(bookRepo.findByStockGreaterThan(120l));
	//	System.out.println(bookRepo.getBooksStockGt(120l));
	//	System.out.println(bookRepo.updateStock(120l, 50l));
		
	}
	
	
	/*
	 * @PostConstruct public void saveBooks() { bookRepo.save(new
	 * Book(1234l,"C",150.25,100l)); bookRepo.save(new
	 * Book(4322l,"CPlus",250.25,100l)); bookRepo.save(new
	 * Book(3456l,"Python",175.25,100l)); bookRepo.save(new Book(5678l, "CSharp",
	 * 225.25, 100l)); }
	 */
	
	

}
