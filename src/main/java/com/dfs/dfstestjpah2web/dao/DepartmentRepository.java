package com.dfs.dfstestjpah2web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dfs.dfstestjpah2web.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	
	List<Department> findAll();

}
