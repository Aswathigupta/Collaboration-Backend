package com.niit.collaboration;

import java.util.Date;

import org.junit.Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

public class TestBlogDAO {

	@Autowired
	static BlogDAO blogDAO;

	@Autowired
	static Blog blog;
	
	@Autowired
	 private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		blog = (Blog) context.getBean("blog");
		blogDAO = (BlogDAO) context.getBean("blogDAO");

	}

	@Test
	public void BlogCreateTestCase() {
		
		blog.setId("BL01");
		blog.setCreatedat(new Date(System.currentTimeMillis()));
		blog.setDescription("this is blog 1");
		blog.setStatus('N');
		blog.setTitle("reunion");
		blogDAO.saveOrUpdate(blog);
		//Assert.assertEquals("Blog test case", true);
	}
	
	@Test
	public void getAllBlogsTestCase()
	{
		Assert.assertEquals("getAllUsersTestCase", 1, blogDAO.list().size());
	}
	
	@Test
	public void updateBlogTestCase() {
		
		blog.setId("BL01");
		blog.setCreatedat(new Date(System.currentTimeMillis()));
		blog.setDescription("this is blog 1");
		blog.setStatus('N');
		blog.setTitle("reunion");
		blogDAO.saveOrUpdate(blog);
	}

}
