package com.training.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

	private Long isbn;
	private String title;
	private Double price;
	private Long stock;
	private int qty;
	private Double amount;
	private int port;
	
}
