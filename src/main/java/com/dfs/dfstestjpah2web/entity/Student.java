package com.dfs.dfstestjpah2web.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends Person{
	@ManyToOne
	private Semester start;
	@ManyToOne
	private Semester end;
	@ManyToOne
	private University university;
	@ManyToOne
	private AcademicCourse academicCourse;
	
	public Student() {}
	
	public Student(String name, String email, int personnelNumber, String description, String password, String office, String department) {
		this.name = name;
		this.email = email;
		this.personnelNumber = personnelNumber;
		this.description = description;
		this.password = password;
		this.office = office;
		this.department = new Department(department);
	}
	
	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
    }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }
	
	public int getPersonnelNumber() {
		return personnelNumber;
	}
	public void setPersonnelNumber(int personnelNumber) {
		this.personnelNumber = personnelNumber;
    }
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
    }
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
    }
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
    }
}
