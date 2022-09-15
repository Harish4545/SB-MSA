package com.training.bean;

import com.training.interfaces.Operator;

public class MultiplyOperator implements Operator {

	@Override
	public void operate(int a, int b) {
		System.out.println("Product:"+(a*b));

	}

}
