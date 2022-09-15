package com.training.bean;

import com.training.interfaces.Operator;

public class OperatorDemo {

	private Operator operator1;

	public OperatorDemo()
	{
		System.out.println("In Constructor..");
	}
	public void setOperator1(Operator operator) {
		System.out.println("In Setter..");
		this.operator1 = operator;
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
		operator1.operate(a, b);
	}
}
