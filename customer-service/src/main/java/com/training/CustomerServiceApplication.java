package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.Customer;
import com.training.repo.CustomerRepo;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Autowired
	private CustomerRepo customerRepo;
	
	@PostConstruct
	public void saveCustomers()
	{
		Customer c1=new Customer(1234l,"sam",36);
		Customer c2=new Customer(3213l,"john",24);
		
		customerRepo.save(c1);customerRepo.save(c2);
		
	}
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
		
			System.out.println(customerRepo.findById(4567l).get());
			System.out.println(customerRepo.findByName("peter"));
			System.out.println(customerRepo.findByAgeLessThan(25));
			System.out.println(customerRepo.getByAge(22));
			System.out.println(customerRepo.getByAgeLt(25));
		};
	}
}
