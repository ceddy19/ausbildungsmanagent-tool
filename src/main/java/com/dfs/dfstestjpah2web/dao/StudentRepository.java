package com.dfs.dfstestjpah2web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfs.dfstestjpah2web.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
