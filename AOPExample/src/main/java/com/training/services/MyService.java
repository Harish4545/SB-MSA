package com.training.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	
	
	public String getName(String name) throws Exception
	{
		if(name==null)
		throw new Exception("Name cannot be null");
		return name;
	}
	
	public Double getSalary()
	{
		return 125500.25;
	}
}
