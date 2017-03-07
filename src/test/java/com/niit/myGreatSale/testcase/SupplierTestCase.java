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
	public void createSupplierTestCase() {
		supplier.setId("SP04032017");
		supplier.setName("baggiwaka");
		supplier.setAddress("Virarjjjj");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);
		// compare what you are expecting Vs what we are getting from save
		// method
	}

	@Test
	public void updateSupplierTestCase() {

		supplier.setId("SP04032017");
		supplier.setName("baggi pvt ltd");
		supplier.setAddress("baggi nagar");

		boolean flag = supplierDAO.update(supplier);
		assertEquals("updateSupplierTestCase", true, flag);
	}

	@Test
	public void getSupplierByIdTestcase() {

		supplier = supplierDAO.getSupplierByID("SP04032017");

		assertEquals("getSupplierByIdTestcase", null, supplier);

	}
	
	@Test
	public void deleteByIdTestCase(){
		
		supplier = supplierDAO.getSupplierByID("SP04032017");
		
		assertEquals("getProductByIdTestcase",null,supplier);
		
	}
	
	

	@Test // It tell the Junit to run this
	public void getallSupplierTestCase() {

		int size = supplierDAO.list().size();

		assertEquals("getallSupplierTestCase", 3, size);
	}

	
	
	
}
