package com.niit.collaboration;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class TestUserDetailsDAO {

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}

	@Test
	public void UserDetailsIdTest() {
		user = userDAO.get("US001");
		String id = user.getId();
		assertEquals("UserDetails id test", "US001", id);
	}

}


