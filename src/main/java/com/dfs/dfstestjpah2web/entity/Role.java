package com.dfs.dfstestjpah2web.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {
	@Id	
	@GeneratedValue
	private int roleId;
	private String name;
	
	@ManyToMany
	private Collection<Person> persons;
	
	public Role() {}
	
	public Role(String name) {
		this.name = name;
		this.persons = new ArrayList<Person>();
	}
	
	public int getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
    }
}
