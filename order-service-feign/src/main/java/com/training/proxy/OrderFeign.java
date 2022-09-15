package com.training.proxy;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.model.Order;

@FeignClient(name="book-service")//,url="http://localhost:8081")
@LoadBalancerClient(name="book-service")
public interface OrderFeign {
	
	@GetMapping("/bookstore/api/book/isbn/{isbn}")
	public Order createOrder(@PathVariable("isbn") Long isbn);
	
	@PostMapping("/bookstore/api/book")
	public Order createOrder1(@RequestBody Order order);
}
