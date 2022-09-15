package com.training.bean;

public class HelloWorld {
	
	private String message;
	private String message1;
	
	public HelloWorld(String message1)
	{
		//System.out.println("Message 1 injected...");
		this.message1=message1;
	}
	
	public HelloWorld() { }
	
	public void setMessage(String message)
	{
		//System.out.println("Message  injected...with setter");
		this.message = message;
		
	}
	
	public String sayHello()
	{
		return message+" "+message1;
	}
	
	

}
