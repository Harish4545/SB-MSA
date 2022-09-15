package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.model.Order;
import com.training.proxy.OrderFeign;

@Service
public class OrderServiceFeign {

	@Autowired
	private OrderFeign orderFeign;
	
	public ResponseEntity<Order> createOrder(Long isbn,int qty)
	{
		Order order = orderFeign.createOrder(isbn);
		
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty);
		System.out.println(order);			
		return new ResponseEntity<Order>(order,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Order> createOrder1(Order order)
	{
		Order order1 = orderFeign.createOrder1(order);
				
		return new ResponseEntity<Order>(order,HttpStatus.OK);
		
	}
	
}
