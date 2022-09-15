package com.training;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.training.bean.Movie;

import com.training.repo.MovieRepo;


@SpringBootApplication
public class MovieProducerProjectApplication {

	@Autowired
	private MovieRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieProducerProjectApplication.class, args);
	}
	
	  @PostConstruct
	  public void init() { 
		  
		  repo.save(new Movie(1234l, "Bhag Milka Bhag", "Biopic"));
		  repo.save(new Movie(3456l, "abc", "Biopic"));
		  repo.save(new Movie(8654l, "xyz", "Thriller"));
		  repo.save(new Movie(6234l, "pqrs", "feelGood"));
		  repo.save(new Movie(321l, "xxxxxx", "Thriller"));
		  repo.save(new Movie(785l, "yyyyyyy", "Thriller"));
	  
	  }
	 
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
			return args->{
			//	System.out.println(repo.findByNameAndMore("abc", 10, 10));
			
			};
	}	
}


