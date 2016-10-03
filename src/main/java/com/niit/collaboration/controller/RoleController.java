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
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.niit.collaboration.dao.RoleDAO;
//import com.niit.collaboration.model.Role;
//import com.niit.collaboration.model.UserRole;
//
//@RestController
//public class RoleController {
//	
//	@Autowired
//	Role role;
//	
//	@Autowired
//	RoleDAO roleDAO;
//	
//	@Autowired
//	UserRole userRole;
//	
//	@GetMapping("/Role")
//	public ResponseEntity<List<Role>> getRoles() {
//		
//		List<Role> list = roleDAO.list();
//		if (list.isEmpty()) {
//			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Role>>(list, HttpStatus.OK);
//	}
//	
//	@GetMapping(value = "/Role/{id}")
//	public ResponseEntity<Role> getBlog(@PathVariable("id") String id) {
//
//		role = roleDAO.get(id);
//		if (role == null) {
//			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Role>(role, HttpStatus.OK);
//	}
//	
//	@PostMapping("/Role")
//	public ResponseEntity<Void> createRole(@RequestBody Role role,UriComponentsBuilder ucBuilder) {
//		if(roleDAO.get(role.getId()) != null)
//		{
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//		roleDAO.save(role);
//		
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setLocation(ucBuilder.path("/Role/{id}").buildAndExpand(role.getId()).toUri());
//		return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
//	}
//	
//	
//	@PutMapping("/Role/{id}")
//	public ResponseEntity<Role> updateRole(@PathVariable String id, @RequestBody Role role) {
//
//		if (roleDAO.get(id) == null) {
//			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
//		}
//
//		roleDAO.update(role);
//
//		return new ResponseEntity<Role>(role, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/Role/{id}")
//	public ResponseEntity<Role> deleteRole(@PathVariable String id) {
//		if (roleDAO.get(id) == null) {
//			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
//		}
//
//		roleDAO.delete(id);
//
//		return new ResponseEntity<Role>( HttpStatus.NO_CONTENT);
//	}
//	
//}
