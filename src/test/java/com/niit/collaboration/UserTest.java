package com.niit.collaboration;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		User user = (User) context.getBean("user");
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);


		user.setId("US003");
		user.setName("Jacky");
		user.setPassword("jack1");
		user.setEmailID("jack1@aol.com");
		user.setAddress("Phoenix");
		user.setContactNumber("9056345622");
		//userDAO.save(user);
		userDAO.update(user);

		System.out.println("\n***********\n"+userDAO.list()+"\n***********\n");
		if (userDAO.get("US003") == null) {
			System.out.println("User does not exist");
		} else {
			System.out.println("User exists..");
		}

	}
}
