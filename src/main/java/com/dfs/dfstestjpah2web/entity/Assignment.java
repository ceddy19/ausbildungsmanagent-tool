package com.dfs.dfstestjpah2web.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Assignment {
	@Id	
	@GeneratedValue
	private int assignmentId;
	private Date startDate;
	private Date endDate;
	private String title;
	private String description;
	private String length;
	
	@ManyToMany(mappedBy = "assignments")
	private Collection<AcademicCourse> courses = new HashSet<>();
	
	/*
	@OneToMany(mappedBy = "projectAssignment")
	private List <Role> projectRoles;
	*/
	
	@ManyToMany(mappedBy = "projectTypeAssignments")
	private Collection<ProjectType> projectTypes = new HashSet<>();
}
