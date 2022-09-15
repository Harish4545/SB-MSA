package com.training.consumers;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class Consumer1 {

	/*
	 * @JmsListener(destination = "test-queue") public void receiveMessage(String
	 * message) { System.out.println("Message received:"+message); }
	 */

	 		@JmsListener(destination = "test-queue") 
	 		public void receiveOrder(List<Order>  orders) 
	 		{ System.out.println("order received:"+orders);
	 		}

}
