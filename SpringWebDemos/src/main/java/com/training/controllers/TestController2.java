package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;

@RestController
public class TestController2 {

	@ResponseBody
	@RequestMapping(value = "/book",method = RequestMethod.GET) //http://localhost:8080/SpringWebDemos/hello
	public Book getBook()
	{
		 return new Book(1234l, "C");
	}
			
	public Book saveBook(@RequestBody Book book)
	{
		// code
		 return new Book(1234l, "C");
	}
	
}
