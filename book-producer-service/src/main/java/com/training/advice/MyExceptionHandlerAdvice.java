package com.training.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.training.exceptions.BookNotFoundException;

@RestControllerAdvice
public class MyExceptionHandlerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String,String> errorMap=new HashMap<>();
		exception.getBindingResult().getFieldErrors()
		.forEach(err->errorMap.put(err.getField(),err.getDefaultMessage()));
		
		return errorMap;
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public String handleBookNotFoundException(BookNotFoundException exception)
	{			
		return exception.getMessage();
		
	}
			
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleBookNotFoundException(NoHandlerFoundException exception)
	{			
		return "Not a Valid Path";
		
	}
	
	
	
}
