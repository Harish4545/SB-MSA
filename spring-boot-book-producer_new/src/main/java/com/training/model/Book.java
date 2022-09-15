package com.training.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity  
@Table(name="books")
public class Book {

	@Id  //primary key
	private Long isbn;
	
	@Column(name="book_title",length = 100,nullable = false)
	private String title;
	private Double price;
	private Long stock;
	//private int port;
	
//	private LocalDate dop;
	
	
}
