package com.niit.collaboration.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "role")
@Component
public class Role {
	
	@Id
	private String id;
	
	private String name;
	
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	
	private Set<UserRole> UserRoles;


	public Set<UserRole> getUserRoles() {
		return UserRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		UserRoles = userRoles; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
