package com.niit.myGreatSale.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.myGreatSale.dao.CategoryDAO;
import com.niit.myGreatSale.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public  static void init() {
		
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
								}
	//TEST Cases to notify it we give @test annotation that test case are here
	
	@Test
//	public void createCategoryTestCase()
//	{
//		category.setId("CG01032017");
//		category.setName("Mobile category");
//		category.setDescription("This is mobile category");
//		
//		boolean flag = categoryDAO.save(category);
//		
//		//compare what you are expecting Vs what we are getting from save method 
//	}
	
	public void updateCategoryTestCase(){
		
		category.setId("CG03032017");
		category.setName("new Category");
		category.setDescription("This is Women category");
		
		boolean flag = categoryDAO.update(category);
		//Assert.assertEquals("updateCategoryTestCase", true ,flag);
	}
	
//	public void deleteTestCase(){
//		
//		categoryDAO.delete("CG02032017");
//	}

}
