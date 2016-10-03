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
//import com.niit.collaboration.dao.UserRoleDAO;
//import com.niit.collaboration.model.UserRole;
//
//@RestController
//public class UserRoleController {
//
//	@Autowired
//	private UserRoleDAO userRoleDAO;
//
//	@Autowired
//	private UserRole userRole;
//
//	@GetMapping("/UserRole/")
//	public ResponseEntity<List<UserRole>> getUserRoles() {
//
//		List<UserRole> list = userRoleDAO.list();
//
//		if (list.isEmpty()) {
//
//			return new ResponseEntity<List<UserRole>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<UserRole>>(list, HttpStatus.OK);
//	}
//
//	@GetMapping("/UserRoles/{id}")
//	public ResponseEntity<UserRole> getUserRole(@PathVariable("id") String id) {
//
//		System.out.println("Fetching UserRole  with id " + id);
//		userRole = userRoleDAO.get(id);
//		if (userRole == null) {
//			return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<UserRole>(userRole, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/UserRole")
//	public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole UserRole) {
//		if (userRoleDAO.get(userRole.getId()) == null) {
//			userRoleDAO.save(UserRole);
//		}
//		return new ResponseEntity<UserRole>(UserRole, HttpStatus.OK);
//	}
//	
//	@PutMapping("/UserRole/{id}")
//	public ResponseEntity<UserRole> updateUserRole(@PathVariable String id, @RequestBody UserRole UserRole) {
//
//		if (userRoleDAO.get(id) == null) {
//			return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
//		}
//
//		userRoleDAO.update(UserRole);
//
//		return new ResponseEntity<UserRole>(UserRole, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/UserRole/{id}")
//	public ResponseEntity<UserRole> deleteUserRole(@PathVariable String id) {
//
//		if (userRoleDAO.get(id) == null) {
//			return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
//		}
//
//		userRoleDAO.delete(id);
//
//		return new ResponseEntity<UserRole>(HttpStatus.OK);
//	}
//
//	
//
//}
