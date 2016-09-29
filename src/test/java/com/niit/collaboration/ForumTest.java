package com.niit.collaboration;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

public class ForumTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");

		Forum forum = (Forum) context.getBean("forum");
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);

		forum.setId("FR01");
		forum.setDescription("FRDesc");
		forum.setForumcomment("Good");
		forum.setCreatedat(timestamp);
		forum.setModifiedat(timestamp);
//		forumDAO.save(forum);
		forumDAO.update(forum);
		
		System.out.println("\n***********\n"+forumDAO.list()+"\n***********\n");
		if (forumDAO.get("FR01") == null) {
			System.out.println("Forum does not exist");
		} else {
			System.out.println("Forum exists..");
		}
	}
}
