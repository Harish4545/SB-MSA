package com.training.services;

import java.util.List;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class JmsService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queue;
	
	public String postMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		
		return message+" published";
	}
	
	public String postOrder(List<Order> orders)
	{
		jmsTemplate.convertAndSend(queue, orders);
		return orders+" published";
	}

}
