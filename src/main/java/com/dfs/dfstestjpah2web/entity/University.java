package com.dfs.dfstestjpah2web.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class University {
	@Id	
	@GeneratedValue
	private int universityId;
	private String name;
	@OneToMany(mappedBy = "university")
	private List <Student> students;
	
	public University() {}
	
	public University(String name) {
		this.name = name;
	}
	
	public int getUniversityId() {
		return universityId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
    }
}
