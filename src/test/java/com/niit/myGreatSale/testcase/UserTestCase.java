package com.niit.myGreatSale.testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.myGreatSale.dao.CategoryDAO;
import com.niit.myGreatSale.dao.UserDAO;
import com.niit.myGreatSale.model.Category;
import com.niit.myGreatSale.model.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void initializer() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	@Test
	public void validateCreationTestCase() {

		boolean flag = userDAO.validate("niit", "niit");
		assertEquals("validateCreationTestCase", true, flag);

	}

	@Test
	public void getUserTestCase() {

		user = userDAO.getUser("UR1");
		assertEquals("getUserTestCase", null, user);

	}

	// To Create the Table
	@Test
	public void createUserTestCase() {
		user.setId("UR1");
		user.setName("Hitesh");
		user.setPassword("hitesh");
		user.setMail("hitesh@gmail.com");
		user.setContact("567879987");

		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);
		// compare what you are expecting Vs what we are getting from save
		// method
	}

	@Test
	public void UpdateUserTestCase() {
		user.setId("UR1");
		user.setName("Hitu");
		user.setPassword("hitu");
		user.setMail("hitu@gmail.com");
		user.setContact("5678700000");

		boolean flag = userDAO.update(user);

		assertEquals("UpdateUserTestCase", true, flag);

	}
	@Test
	public void getallUserTestCase() {

		int size = userDAO.list().size();

		assertEquals("getallUserTestCase", 3, size);
	}

}
