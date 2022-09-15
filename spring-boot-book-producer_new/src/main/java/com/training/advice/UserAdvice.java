package com.training.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Map handleUserInputExceptions(MethodArgumentNotValidException ex)
	{
		Map<String,String> map = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(err->map.put(err.getField(),err.getDefaultMessage()));
		
		return map;
	}
	
	
}
