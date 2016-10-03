package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {

	public List<User> list();

	public User get(String id);

	public boolean save(User user);
	
	public boolean update(User user);

	public boolean delete(String id);
	
	public User authenticate(String id,String password);
}
