package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.OrderService;

@RequestMapping("/orders/api")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/isbn/{isbn}/qty/{qty}")
	public ResponseEntity<Order> createOrder(@PathVariable("isbn") Long isbn,@PathVariable("qty") int qty)
	{
		return orderService.createOrder(isbn, qty);
	}
	
	// http://localhost:8080/authenticate
	@PostMapping("/gettoken")
	public String authenticate()
	{
		String token = orderService.authenticate();
		System.out.println(token);
		return token;
	}
}
