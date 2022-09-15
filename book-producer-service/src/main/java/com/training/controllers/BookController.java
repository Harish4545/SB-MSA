package com.training.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.BookDto;
import com.training.exceptions.BookNotFoundException;
import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	@Autowired
	private BookServiceI bookService;

	//http://localhost:8081/bookstore/api/books
	@GetMapping("/books")
	public List<BookDto> getBooks()
	{
		return bookService.getBooks();
	}

	//http://localhost:8081/bookstore/api/book
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/book")
	public BookDto saveBook(@RequestBody @Valid BookDto bookDto)
	{	
		return bookService.saveBook(bookDto);
	}

	//http://localhost:8081/bookstore/api/book/isbn/1234
	@GetMapping("/book/isbn/{isbn}")
	public ResponseEntity<BookDto> getBook(@PathVariable("isbn") Long isbn) throws BookNotFoundException
	{
		BookDto bookFoundDto = bookService.getBook(isbn);
		if(bookFoundDto!=null)
			return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.OK);
		return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/book/isbn/{isbn}")
	public ResponseEntity<BookDto> deleteBook(@PathVariable("isbn") Long isbn)
	{
		BookDto bookFoundDto = bookService.deleteBook(isbn);
		if(bookFoundDto!=null)
			return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.OK);
		return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/book/isbn/{isbn}/stock/{stock}")
	public ResponseEntity<BookDto> updateStockBook(@PathVariable("isbn") Long isbn,@PathVariable("stock") Long stock)
	{
		BookDto bookFoundDto = bookService.updateBook(isbn, stock);
		if(bookFoundDto!=null)
			return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.OK);
		return new ResponseEntity<BookDto>(bookFoundDto, HttpStatus.NOT_FOUND);
	}
}
