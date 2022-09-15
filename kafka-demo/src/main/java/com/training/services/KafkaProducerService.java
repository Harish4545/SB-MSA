package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class KafkaProducerService {
	
	private static final String TOPIC = "kafka_topic_text";
	private static final String TOPIC1 = "kafka_topic_order";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateText;
	
	@Autowired
	private KafkaTemplate<String,Order> kafkaTemplateOrder;
	
	
	public String postMessage(String message)
	{
		kafkaTemplateText.send(TOPIC, "id",message);
		
		return message+" published";
	}
	public String postOrder(Order order)
	{
		kafkaTemplateOrder.send(TOPIC1, String.valueOf(order.getOrderId()),order);
		
		return order+" published";
	}
	
}
