package com.training.bean;

import com.training.interfaces.Operator;

public class AddOperator implements Operator {

	@Override
	public void operate(int a, int b) {
		System.out.println("Sum:"+(a+b));

	}

}
