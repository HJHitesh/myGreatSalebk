package com.niit.myGreatSale.testcase;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.myGreatSale.dao.SupplierDAO;

import com.niit.myGreatSale.model.Supplier;

public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	
	@Test
		public void deleteByIdTestCase(){
			
			boolean flag = supplierDAO.delete("SP01032017");
			
			assertEquals("getProductByIdTestcase",true,flag);
			
			
		}
	
	
	@Test
	public void deleteBySupplierTestCase() {

		supplier.setId("CG02032017");

		boolean flag = supplierDAO.delete(supplier);

		assertEquals("deleteBySupplierTestCase", true, flag);

	}


	@Test
	public void createSupplierTestCase() {
		
		supplier.setId("SP09032017");
		supplier.setName("bassdggiwaka");
		supplier.setAddress("Visddsrarjjjj");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);
		
	}

	@Test
	public void updateSupplierTestCase() {
		
		supplier = new Supplier();
		supplier.setId("SP09032017");
		supplier.setName("hitesh33333");
		supplier.setAddress("virar Bolinaj");
		
		boolean flag = supplierDAO.update(supplier);
		
		assertEquals("updateSupplierTestCase",true, flag);
		
	}
	
	

	
	@Test
	public void getSupplierByIdTestcase() {

		supplier = supplierDAO.getSupplierByID("SP01032017d");
		
		assertEquals("getSupplierByIdTestcase", null, supplier);
		
		System.out.println(supplier);
		
	}
	
	
	@Test
	public void getSupplierByNameTestCase() {

		supplier = supplierDAO.getSupplierByName("hiteshsas");
		
		assertEquals("getSupplierByNameTestCase", null, supplier);
		
		
		
	}
	//@Test 
	public void getallSupplierTestCase() {

		int size = supplierDAO.list().size();
		
		assertEquals("getallSupplierTestCase", 6, size);
		
	}

}
