package com.niit.collaboration.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "userdetails")
@Component
public class User {

	@Id
	private String id;

	private String name;
	
	private String password;

	private String emailID;

	private String address;

	private String contactNumber;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	

}

