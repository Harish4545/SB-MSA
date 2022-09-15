package com.training.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.training.dto.BookDto;
import com.training.model.Book;

@Component
public class AppUtil {
	
	public Book BookDtoToBook(BookDto bookDto)
	{
		Book book=new Book();
		BeanUtils.copyProperties(bookDto, book);
		return book;
	}

	public BookDto BookToBookDto(Book book)
	{
		BookDto bookDto=new BookDto();
		BeanUtils.copyProperties(book, bookDto);
		return bookDto;
	}
}
