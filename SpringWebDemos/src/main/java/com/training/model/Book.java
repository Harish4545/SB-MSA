package com.training.model;

public class Book  {
	private Long isbn;
	private String title;
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Book(Long isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	
	
	
}
