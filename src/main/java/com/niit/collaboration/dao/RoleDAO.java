package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Role;

public interface RoleDAO {

	public List<Role> list();

	public Role get(String id);

	public boolean save(Role role);

	public boolean update(Role role);

	public boolean delete(String id);

}
