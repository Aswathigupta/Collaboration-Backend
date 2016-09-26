package com.niit.collaboration;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

public class BlogTesting {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");

		Blog blog = (Blog) context.getBean("blog");
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);


		blog.setId("BL025566");
		blog.setDescription("Annual Day Ceremony");
		blog.setTitle("Ceremony");
		blog.setStatus('A');
		blog.setCreatedat(timestamp);
		blogDAO.saveOrUpdate(blog);

		System.out.println("\n***********\n"+blogDAO.list()+"\n***********\n");
		if (blogDAO.get("BL01") == null) {
			System.out.println("blog does not exist");
		} else {
			System.out.println("blog exists..");
		}
	}
}