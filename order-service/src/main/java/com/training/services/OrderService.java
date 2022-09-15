package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.config.OrderConfig;
import com.training.model.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {


	private String producerUrl = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";
	
	@Autowired
	private OrderConfig orderConfig;
	
	//private String producerUrl;

	@Autowired
	private RestTemplate restTemplate;

	@CircuitBreaker(name = "instanceA",fallbackMethod = "getBookDefault")
	public ResponseEntity<Order> createOrder(Long isbn,int qty)
	{
	//	producerUrl = orderConfig.getServiceUrl();
		Map<String,String> map= new HashMap<>();
		map.put("isbn", String.valueOf(isbn));

	//	Order order = restTemplate.getForObject(producerUrl,Order.class,map);
		
		ResponseEntity<Order> responseOrder = restTemplate.getForEntity(producerUrl, Order.class, map);
		
		Order order = responseOrder.getBody();
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty);
		
		return responseOrder;
		
	}
	
	public ResponseEntity<Order> getBookDefault(Exception e)
	{
		return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
	}
		
	public String authenticate()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String request = "{\"username\":\"user1\",\"password\":\"user123\"}";
		HttpEntity<String> entity= new HttpEntity<String>(request,headers);
		String token = restTemplate.postForObject("http://localhost:8080/authenticate", entity, String.class);
		
		System.out.println(token);
		
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer "+token);
		HttpEntity<String> entity1= new HttpEntity<String>(headers1);
		
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/user/hello",
				HttpMethod.GET, entity1, String.class);
		
		return response.getBody();
	}
	
	
}
