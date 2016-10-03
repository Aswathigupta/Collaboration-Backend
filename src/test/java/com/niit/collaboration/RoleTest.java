package com.niit.collaboration;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.RoleDAO;
import com.niit.collaboration.model.Role;

public class RoleTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	context.scan("com.niit");
	context.refresh();

	RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO");

	Role role = (Role) context.getBean("role");
	
	role.setId("R01");
	role.setName("Marie");
	
//	roleDAO.save(role);
	roleDAO.update(role);

	if (roleDAO.get("R01") == null) {
		System.out.println("Role does not exist");
	} else {
		System.out.println("Role exists..");
	}
}

}
