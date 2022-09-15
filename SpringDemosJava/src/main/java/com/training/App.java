package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;
import com.training.config.MyConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
		OperatorDemo demo = ctx.getBean(OperatorDemo.class);
		demo.getResult(12, 23);

	}
}
