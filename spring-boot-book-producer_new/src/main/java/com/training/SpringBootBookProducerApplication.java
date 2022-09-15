package com.training;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Book;
import com.training.repo.BookRepo;

//@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootBookProducerApplication{// implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookProducerApplication.class, args);
	}
	
	@Autowired
	private BookRepo bookRepo;
	
	
	  @PostConstruct public void saveBooks() { bookRepo.save(new Book(1234l, "C",
	  120.50, 100l)); bookRepo.save(new Book(3456l, "CPlus", 150.50, 150l));
	  bookRepo.save(new Book(5678l, "Python", 170.50, 120l)); bookRepo.save(new
	  Book(5674l, "C", 45.50, 100l)); }
	 
	
	//CommandLineRunner
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			//System.out.println(bookRepo.findByTitleLike("%C%"));
			//System.out.println(bookRepo.getByStockGreaterThan(100l));
			
			//System.out.println(bookRepo.updateStockTitle("%C%", 25l));
		};
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

	
}




