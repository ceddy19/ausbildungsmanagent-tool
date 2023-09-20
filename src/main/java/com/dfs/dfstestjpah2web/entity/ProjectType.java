package com.dfs.dfstestjpah2web.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ProjectType {
	@Id	
	@GeneratedValue
	private int projectTypeId;
	private String name;
	@ManyToMany
	private Collection<Assignment> projectTypeAssignments;
	
	public ProjectType() {}
	
	public ProjectType(String name) {
		this.name = name;
	}
	
	public int getProjectTypeId() {
		return projectTypeId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
    }
}
