package com.training.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.training.interfaces.Operator;

public class OperatorDemo {

	//@Autowired
	//@Qualifier(value = "add")
	private Operator operator;

	
	public OperatorDemo(@Qualifier(value="add") Operator operator)
	{
		this.operator=operator;
	}
	public OperatorDemo()
	{
		System.out.println("In Constructor..");
	}

	
	public void init()
	{
		System.out.println("Init method..");
	}
	
	public void destroy()
	{
		System.out.println("Destroy method..");
	}
	
	public void getResult(int a,int b)
	{
		System.out.println("In getResult..");
		operator.operate(a, b);
	}
}
