package com.training.consumers;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class Consumer1 {

	@KafkaListener(topics = "kafka_topic_order") 
		public void receiveOrder(Order  order) 
		{ System.out.println("order received:"+order);
		}

	
}
