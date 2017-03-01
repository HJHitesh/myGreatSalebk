package com.niit.myGreatSale.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTest {

	public static 
	
	void main(String[] args) {
		// TODO Auto-generated method stub
		//
		// we have get context
		// ask context to get the bean ie. category

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.myGreatSale");//It will Create all the Component

		context.refresh();

		// whatever the beans/instances you requires ,you ask context

		Category c = (Category) context.getBean("category");//Also follow the proper convention //It will create the Object of Category Class

		System.out.println("Category instance created");
		
		//ClassPath
		
		
	}

}
