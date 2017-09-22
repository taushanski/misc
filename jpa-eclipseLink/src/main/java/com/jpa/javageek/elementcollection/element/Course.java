package com.jpa.javageek.elementcollection.element;

import javax.persistence.Embeddable;

@Embeddable
public class Course {

	private String coursename;
	private String description;

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}