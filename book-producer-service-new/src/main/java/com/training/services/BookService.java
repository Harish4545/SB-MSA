package com.training.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.BookDto;
import com.training.exceptions.BookNotFoundException;
import com.training.interfaces.BookServiceI;
import com.training.model.Book;
import com.training.repo.BookRepo;
import com.training.utils.AppUtil;

@Service
public class BookService implements BookServiceI{

	@Autowired
	private AppUtil appUtil;	
	
	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<BookDto> getBooks() { // needs to be updated to BookDto
		List<BookDto> list=new ArrayList<>();
		
		bookRepo.findAll().stream().forEach(obj->list.add(appUtil.BookToBookDto(obj)));
		return list;
	}

	@Override
	public BookDto getBook(Long isbn) throws BookNotFoundException {
		
	//	Book bookFound = bookRepo.getById(isbn);
		Optional<Book> bookOp = bookRepo.findById(isbn);
		Book bookFound=null;
		if(bookOp.isPresent()) {
			bookFound = bookOp.get();
			//System.out.println("Book found.."+bookFound);
			return appUtil.BookToBookDto(bookFound);
		}
		else
			throw new BookNotFoundException("Book Not Found Exception");
		
		//return null;
	}

	@Override
	public BookDto saveBook(BookDto bookDto) {
		System.out.println("BookDto:"+bookDto);
		Book book = appUtil.BookDtoToBook(bookDto);
		//set other properties
		bookRepo.save(book);
		BookDto bookDto1=appUtil.BookToBookDto(book);
		return bookDto1;
	}

	@Override
	public BookDto deleteBook(Long isbn) {
		Optional<Book> bookOp = bookRepo.findById(isbn);
		Book bookFound=null;
		if(bookOp.isPresent()) {
			bookFound = bookOp.get();
			bookRepo.delete(bookFound);
			return appUtil.BookToBookDto(bookFound);
		}
		return null;
	}

	@Override
	public BookDto updateBook(Long isbn, Long newStock) {
		
		Optional<Book> bookOp = bookRepo.findById(isbn);
		Book bookFound=null;
		if(bookOp.isPresent()) {
			bookFound = bookOp.get();
			bookFound.setStock(bookFound.getStock()+newStock);
			bookRepo.save(bookFound);
			
			return appUtil.BookToBookDto(bookFound);
		}
		return null;
	}
	
	

}
