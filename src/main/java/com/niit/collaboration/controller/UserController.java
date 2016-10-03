package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@GetMapping("/user/")
	public ResponseEntity<List<User>> getUsers() {

		List<User> list = userDAO.list();

		if (list.isEmpty()) {

			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {

		System.out.println("Fetching User  with id " + id);
		user = userDAO.get(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		if (userDAO.get(user.getId()) == null) {
			userDAO.save(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {

		if (userDAO.get(id) == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userDAO.update(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// @PostMapping("/user/authenticate")
	// public ResponseEntity<User> authenticate(@RequestBody User user) {
	//
	// user = userDAO.authenticate(user.getId(), user.getPassword());
	// if (user != null) {
	// return new ResponseEntity<User>(user, HttpStatus.OK);
	// }
	// return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
	// }

	@PostMapping("/user/authenticate")
	public ResponseEntity<User> authenticate(@RequestBody User user) {

		user = userDAO.authenticate(user.getId(), user.getPassword());
		if (user == null) {
			user = new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invalid Credentials!!!");

		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable String id) {

		if (userDAO.get(id) == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userDAO.delete(id);

		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
