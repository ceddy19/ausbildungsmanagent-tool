package com.dfs.dfstestjpah2web.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class AcademicCourse {
	@Id	
	@GeneratedValue
	private int courseId;
	private String name;
	@OneToMany(mappedBy = "academicCourse")
	private List <Student> students;
	@ManyToMany
	private Collection<Staff> staffs;
	@ManyToMany
	private Collection<Assignment> assignments;
	
	public AcademicCourse() {}
	
	public AcademicCourse(String name) {
		this.name = name;
	}
	
	public int getCourseId() {
		return courseId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
    }
}
