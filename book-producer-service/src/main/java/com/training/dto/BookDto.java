package com.training.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

	
	private Long isbn;
	
	@NotBlank(message="Title cannot be blank")
	private String title;
	
	@Min(value=10,message="minimum price should be 10Rs")
	private Double price;
	
	@Min(value=100,message="minimum stock should be 100")
	@Max(value=300,message="maximum stock should be 300")
	private Long stock;
	
}
