package com.dfs.dfstestjpah2web.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id	
	@GeneratedValue
	private int departmentId;
	private String shortLabel;
	private String longLabel;
	@OneToMany(mappedBy = "department")
	private List <Person> persons;
	
	public Department() {}
	
	public Department(String shortLabel) {
		this.shortLabel = shortLabel;
	}
	
	public String getShortLabel() {
		return shortLabel;
	}
}
