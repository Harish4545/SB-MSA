package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.OrderServiceFeign;

@RequestMapping("/orders/api")
@RestController
public class OrderController {

	@Autowired
	private OrderServiceFeign orderService;
	
	//localhost:8085/orders/api/isbn/1234/qty/10
	
	@GetMapping("/isbn/{isbn}/qty/{qty}")
	public ResponseEntity<Order> createOrder(@PathVariable("isbn") Long isbn,@PathVariable("qty") int qty)
	{
		return orderService.createOrder(isbn, qty);
	}
	

}
