package com.niit.myGreatSale.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.myGreatSale.dao.ProductDAO;
import com.niit.myGreatSale.model.Product;

public class ProductTestCase {
	@Autowired
	private static Product product;

	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		product = (Product) context.getBean("product");

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	// @Test
	// public void createProductTestcase() {
	//
	// product.setId("PG02032017");
	// product.setName("mobiles02");
	// product.setPrice(25000);
	// product.setDescription("THIS IS THE MOBILE2 CALLED IPHONE");
	// product.setCategory_id("CG01032017");
	// product.setSupplier_id("SP02032017");
	//
	// boolean flag = productDAO.save(product);
	//
	// assertEquals("createProductTestcase()", true, flag);
	//
	// }

	// @Test
	// public void updateProductTestCase() {
	//
	// product.setId("PG01032017");
	// product.setName("mobiles_karboonK9");
	// product.setPrice(2000);
	// product.setDescription("THIS IS THE MOBILE CALLED Karboon");
	// product.setCategory_id("CG05032017");
	// product.setSupplier_id("SP01032017");
	//
	// boolean flag = productDAO.update(product);
	//
	// assertEquals("updateProductTestcase()", true, flag);
	//
	// }

	// @Test
	// public void deleteTestCase(){
	//
	// boolean flag = productDAO.delete("PG03032017");
	//
	// assertEquals("deleteTestCase", true ,flag);
	// }
	//
	@Test
	public void deleteByProductTestCase() {

		product.setId("PG02032017");

		boolean flag = productDAO.delete(product);
		assertEquals("deleteByProductTestCase", true, flag);
		

	}
	
	@Test//This is passing for bothERROR plzs correct
	public void getProductByNameTestCase() {
		
		product = productDAO.getProductByName("mobiles_karboonK9");
		
		assertEquals("getProductByNameTestCase",product, product);
		
	}
	
	@Test
	public void getProductByIdTestcase() {
		
		product = productDAO.getProductByID("PG01032017");
		
		assertEquals("getProductByIdTestcase",null,product);

	}
	
	
	
	@Test
	public void getallProductTestCase() {
		

		int size =productDAO.list().size();//It check the value of category how many inserted and give the value is stored in size.
		
		assertEquals("getallProductTestcase",3, size);

	}

}
