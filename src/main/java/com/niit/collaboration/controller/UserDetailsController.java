//package com.niit.collaboration.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.niit.collaboration.dao.UserDetailsDAO;
//import com.niit.collaboration.model.UserDetails;
//import com.niit.collaboration.model.Role;
//import com.niit.collaboration.model.UserDetails;
//import com.niit.collaboration.model.UserRole;
//
//@RestController
//public class UserDetailsController {
//
//	@Autowired
//	private UserDetailsDAO userDetailsDAO;
//
//	@Autowired
//	private UserDetails userDetails;
//	
////	@Autowired
////	private UserRole userRole;
////
////	@Autowired
////	private Role role;	
//
//	@GetMapping("/userDetails/")
//	public ResponseEntity<List<UserDetails>> getUserDetails() {
//
//		List<UserDetails> list = userDetailsDAO.list();
//		if (list.isEmpty()) {
//			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<UserDetails>>(list, HttpStatus.OK);
//	}
//
////	@GetMapping("/UserDetails/{id}")
////	public ResponseEntity<UserDetails> getUserDetails(@RequestParam("id") String id) {
////
////		userDetails = userDetailsDAO.get(id);
////		if (userDetails == null) {
////			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
////		}
////
////		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
////	}
////
////	@PostMapping(value = "/UserDetails")
////	public ResponseEntity<Void>  createUserDetails(@RequestBody UserDetails userDetails ,UriComponentsBuilder ucBuilder) {
////
////		if(userDetailsDAO.get(userDetails.getId()) != null ) {
////			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
////		}
////		
////		role.setId("ROLE_USER");
////		role.setName("ROLE_USER");
////		userRole.setId("ROLE_USER");
////		userRole.setRole(role);
//////		userDetails.setUserRole(userRole);
////		userDetailsDAO.saveOrUpdate(userDetails);
////		
////		HttpHeaders httpHeaders = new HttpHeaders();
////		httpHeaders.setLocation(ucBuilder.path("/userDetails/{id}").buildAndExpand(userDetails.getId()).toUri());
////		return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
////		
////		
////
////	}
////	
////	@PostMapping(value = "/UserDetails")
////	public ResponseEntity<UserDetails> authenticate(@RequestParam("username") String id,
////					@RequestParam("password") String password) {
////
////		userDetailsDAO.saveOrUpdate(userDetails);
////
////		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
////	}
////
////	@DeleteMapping("/UserDetails/{id}")
////	public ResponseEntity<UserDetails> deleteUserDetails(@PathVariable("id") String id) {
////	
////		if (userDetailsDAO.get(id) == null) {
////			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
////		}
////
////		userDetailsDAO.delete(id);
////
////		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
////	}
////
////	@PutMapping("/UserDetails/{id}")
////	public ResponseEntity<UserDetails> updateUserDetails(@PathVariable("id") String id, @RequestBody UserDetails userDetails) {
////
////		if (userDetailsDAO.get(id) == null) {
////			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
////		}
////
////		userDetailsDAO.saveOrUpdate(userDetails);
////
////		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
////	}
//}
//
//
