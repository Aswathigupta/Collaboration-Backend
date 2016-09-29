//package com.niit.collaboration.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.niit.collaboration.dao.JobDAO;
//import com.niit.collaboration.model.Job;
//
//@RestController
//public class JobController {
//
//	@Autowired
//	private JobDAO jobDAO;
//
//	@Autowired
//	private Job job;
//
//	@GetMapping("/Job/")
//	public ResponseEntity<List<Job>> getJobs() {
//
//		List<Job> list = jobDAO.list();
//
//		if (list.isEmpty()) {
//
//			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Job>>(list, HttpStatus.OK);
//	}
//
//	@GetMapping("/Jobs/{id}")
//	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
//
//		System.out.println("Fetching Job  with id " + id);
//		job = jobDAO.get(id);
//		if (job == null) {
//			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Job>(job, HttpStatus.OK);
//	}
//	
//
//	@PostMapping(value = "/Job")
//	public ResponseEntity<Job> createJob(@RequestBody Job Job) {
//		if (jobDAO.get(job.getId()) == null) {
//			jobDAO.save(Job);
//		}
//		return new ResponseEntity<Job>(Job, HttpStatus.OK);
//	}
//	
//	@PutMapping("/Job/{id}")
//	public ResponseEntity<Job> updateJob(@PathVariable String id, @RequestBody Job Job) {
//
//		if (jobDAO.get(id) == null) {
//			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
//		}
//
//		jobDAO.update(Job);
//
//		return new ResponseEntity<Job>(Job, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/Job/{id}")
//	public ResponseEntity<Job> deleteJob(@PathVariable String id) {
//
//		if (jobDAO.get(id) == null) {
//			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
//		}
//
//		jobDAO.delete(id);
//
//		return new ResponseEntity<Job>(HttpStatus.OK);
//	}
//
//	
//
//}
