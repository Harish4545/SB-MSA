package com.training.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {
	
	public Customer findByName(String name);
	
	public List<Customer> findByAgeLessThan(int age);
	
	@Query("{age:?0}")
	public List<Customer> getByAge(@Param("age") int age);
	
	@Query("{age:{$lt:?0}}")
	public List<Customer> getByAgeLt(@Param("age") int age);
}
