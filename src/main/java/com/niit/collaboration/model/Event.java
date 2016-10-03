package com.niit.collaboration.model;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class Event {

	private String id;
	
	@Transient
	private MultipartFile image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
