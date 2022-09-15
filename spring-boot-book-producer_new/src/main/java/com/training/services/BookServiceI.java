package com.training.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.model.Book;

public interface BookServiceI {
	
	public Book addBook(Book book);
	public List<Book> getBooks();
	public Book getBook(Long isbn);
	
	//delete a book
	public Book deleteBook(Long isbn);
	
	//update the stock
	public Book updateBookStock(Long isbn,Long newStock);
	
	public String sayHello();
	
	public int sum(int x,int y);

}
