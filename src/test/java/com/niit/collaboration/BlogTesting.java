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


		blog.setId("BL04");
		blog.setDescription("Reunion of alumnis");
		blog.setTitle("Reunion");
		blog.setStatus('P');
		blog.setCreatedat(timestamp);
		blogDAO.save(blog);
		//blogDAO.update(blog);

		System.out.println("\n***********\n"+blogDAO.list()+"\n***********\n");
		if (blogDAO.get("BL01") == null) {
			System.out.println("blog does not exist");
		} else {
			System.out.println("blog exists..");
		}
	}
}