package com.niit.collaboration.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "forum")
@Component
public class Forum {
	
	@Id
	private String id;
	private String description;
	private String forumcomment;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	private Timestamp createdat;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	private Timestamp modifiedat;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getForumcomment() {
		return forumcomment;
	}
	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}
	public Timestamp getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}
	public Timestamp getModifiedat() {
		return modifiedat;
	}
	public void setModifiedat(Timestamp modifiedat) {
		this.modifiedat = modifiedat;
	}
	
	

}
