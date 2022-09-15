package com.training.interfaces;

import java.util.List;

import com.training.dto.BookDto;
import com.training.exceptions.BookNotFoundException;
import com.training.model.Book;

public interface BookServiceI {
	
	//retrieve all books
	public List<BookDto> getBooks();
	
	//retrieve a book based on isbn
	public BookDto getBook(Long isbn) throws BookNotFoundException;
	
	//save a book
	public BookDto saveBook(BookDto book);
	//delete book based on isbn
	public BookDto deleteBook(Long isbn);
	//add stock on isbn
	public BookDto updateBook(Long isbn,Long newStock);
	

}
