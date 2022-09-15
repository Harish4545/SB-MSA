package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.JmsService;

@RestController
public class JmsController {

	@Autowired
	private JmsService jmsService;
	
	@GetMapping("/{message}")
	public String postMessage(@PathVariable("message") String message)
	{
		return jmsService.postMessage(message);
	}
	
	@PostMapping
	public String postOrder(@RequestBody List<Order> orders)
	{
		return jmsService.postOrder(orders);
	}
}
