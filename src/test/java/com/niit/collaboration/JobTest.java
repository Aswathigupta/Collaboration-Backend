package com.niit.collaboration;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;

public class JobTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");

		Job job = (Job) context.getBean("job");
		
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);

		job.setId("J01");
		job.setJobtitle("Developer");
		job.setDescription("JOB Desc");
		job.setRequirement("java developers");
		job.setCompany("CTS");
		job.setDateofposting(timestamp);
//		jobDAO.save(job);
		jobDAO.update(job);
		
		System.out.println("\n***********\n"+jobDAO.list()+"\n***********\n");
		if (jobDAO.get("J01") == null) {
			System.out.println("Job does not exist");
		} else {
			System.out.println("Job exists..");
		}
	}

}
