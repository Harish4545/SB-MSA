package com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="books")
public class Book {

	@Id
	private Long isbn;
	
	@Column(name="title",length=100,nullable=true)
	private String title;
	private Double price;
	private Long stock;
	
}
