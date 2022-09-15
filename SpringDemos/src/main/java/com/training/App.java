package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;
import com.training.bean.OperatorDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // load the xml file
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	// get an instance of HelloWorld
    	
		/*
		 * HelloWorld bean = (HelloWorld) ctx.getBean("hello");
		 * 
		 * System.out.println(bean.sayHello());
		 */
    	
    	
    	OperatorDemo demo = (OperatorDemo) ctx.getBean("demo"); // instance created
    	demo.getResult(12, 23);
    	//System.out.println(demo.hashCode());
    	
    	OperatorDemo demo1 = (OperatorDemo) ctx.getBean("demo"); // instance is retrieved
    	//System.out.println(demo1.hashCode());
    	
    	
    }
}
