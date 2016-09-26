package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "blog")
@Component
public class Blog implements Serializable {
	
	private static final long serialVersionUID = 5446939089491045939L;

	@Id
	private String id;

	private String title;
	
	private String description;

	private char status;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	private Date createdat;

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date date) {
		this.createdat = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	public Blog() {
		this.id = "BLG" + UUID.randomUUID().toString().substring(24).toUpperCase();

	}

	

}
