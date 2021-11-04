package com.cogent.emsmongodb.utils;

import org.springframework.beans.factory.annotation.Autowired;

//https://codeshare.io/oQ0L7M

public class BeanOne {
	BeanTwo beanTwo;
	@Autowired
	public BeanOne(BeanTwo beanTwo ) {
	      
		//this.beanTwo = beanTwo;
		
		System.out.println("BeanOne Initialized");
	   
	}

	

	public void doSomthing() {
	   
		System.out.println("Inside doSomthing() method of BeanOne");
	   }
	
	
	
	

}
