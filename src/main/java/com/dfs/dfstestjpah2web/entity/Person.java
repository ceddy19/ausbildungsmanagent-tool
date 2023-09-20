package com.dfs.dfstestjpah2web.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@Id	
	@GeneratedValue
	protected int userId;
	
	@Column(nullable = false)
	protected String name;
	
	protected String email;
	protected int personnelNumber;
	protected String description;
	protected String password;
	protected String office;
	protected Date createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Department department;
	
	@ManyToMany(mappedBy = "persons")
	protected Collection<Role> generalRoles = new HashSet<>();
	
	@ManyToMany 
	@JoinTable(name = "USER_PROJECT", 
		joinColumns = @JoinColumn(name = "ASSIGNMENT_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ROLE_ID")) 
	@MapKeyJoinColumn(name = "PERSON_ID") 
	protected Map<Assignment, Role> projects = new HashMap<>(); 
	
	
	public Person() {}
	
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
}
