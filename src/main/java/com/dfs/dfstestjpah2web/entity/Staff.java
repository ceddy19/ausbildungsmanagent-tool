package com.dfs.dfstestjpah2web.entity;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Staff extends Person{
	private String function;
	@ManyToMany(mappedBy = "staffs")
	private Collection<AcademicCourse> courses = new HashSet<>();
}
