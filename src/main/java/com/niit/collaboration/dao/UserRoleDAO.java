package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.UserRole;

public interface UserRoleDAO {

	public List<UserRole> list();

	public UserRole get(String id);

	public boolean save(UserRole userRole);

	public boolean update(UserRole userRole);

	public boolean delete(String id);
}
