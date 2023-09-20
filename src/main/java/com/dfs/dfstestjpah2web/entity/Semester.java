package com.dfs.dfstestjpah2web.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Semester {
	@Id	
	@GeneratedValue
	private int semesterId;
	private String name;
	private Date startDate;
	private Date endDate;
	@OneToMany(mappedBy = "start")
	private List <Student> startStudents;
	@OneToMany(mappedBy = "end")
	private List <Student> endStudents;
	
	public Semester() {}
	
	public Semester(String name, Date startDate, Date endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getSemesterId() {
		return semesterId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
    }

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
    }

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
    }
}
