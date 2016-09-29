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
//import com.niit.collaboration.dao.ForumDAO;
//import com.niit.collaboration.model.Forum;
//
//@RestController
//public class ForumController {
//
//	@Autowired
//	private ForumDAO forumDAO;
//
//	@Autowired
//	private Forum forum;
//
//	@GetMapping("/forums/")
//	public ResponseEntity<List<Forum>> getForums() {
//
//		List<Forum> list = forumDAO.list();
//		if (list.isEmpty()) {
//			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Forum>>(list, HttpStatus.OK);
//	}
//
//	@GetMapping("/forums/{id}")
//	public ResponseEntity<Forum> getForum(@PathVariable("id") String id) {
//
//		forum = forumDAO.get(id);
//		if (forum == null) {
//			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/forum")
//	public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
//		if (forumDAO.get(forum.getId()) == null) {
//			forumDAO.save(forum);
//		}
//		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
//	}
//	
//	@PutMapping("/forum/{id}")
//	public ResponseEntity<Forum> updateForum(@PathVariable String id, @RequestBody Forum Forum) {
//
//		if (forumDAO.get(id) == null) {
//			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
//		}
//
//		forumDAO.update(forum);
//
//		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
//	}
//
//
//	@DeleteMapping("/forum/{id}")
//	public ResponseEntity<Forum> deleteForum(@PathVariable String id) {
//
//		if (forumDAO.get(id) == null) {
//			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
//		}
//
//		forumDAO.delete(id);
//
//		return new ResponseEntity<Forum>(HttpStatus.OK);
//	}
//
//	
//}
