package com.niit.collaboration;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.RoleDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.dao.UserRoleDAO;
import com.niit.collaboration.model.UserRole;

public class UserRoleTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		UserRoleDAO userRoleDAO = (UserRoleDAO) context.getBean("userRoleDAO");

		UserRole userRole = (UserRole) context.getBean("userRole");
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO");
		
		userRole.setId("UR01");
		userRole.setUser(userDAO.get("US001"));
		userRole.setRole(roleDAO.get("R01"));
	
//		userRoleDAO.save(userRole);
		userRoleDAO.update(userRole);
		
		userRoleDAO.list();

		if (userRoleDAO.get("UR01") == null) {
			System.out.println("UserRole does not exist");
		} else {
			System.out.println("UserRole exists..");
		}
	}

}
