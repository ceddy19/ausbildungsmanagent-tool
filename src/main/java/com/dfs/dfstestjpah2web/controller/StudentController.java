package com.dfs.dfstestjpah2web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.dfstestjpah2web.dao.DepartmentRepository;
import com.dfs.dfstestjpah2web.entity.Department;
import com.dfs.dfstestjpah2web.entity.Student;
import com.dfs.dfstestjpah2web.entity.Student;
import com.dfs.dfstestjpah2web.entity.Student;
import com.dfs.dfstestjpah2web.service.StudentService;

import dto.StudentDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	private DepartmentRepository departmentRepository;

	@PostMapping("")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto createStudentDto) throws ResourceNotFoundException {
		
		// Find department
		/*
		List<Department> tutorials = new ArrayList<>();
		tutorials = departmentRepository.findAll();
		System.out.println(tutorials);
		*/
		
	    Student studentInput = createStudentDto.toStudent();
	    Student createdStudent = studentService.createStudent(studentInput);
	
	    return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Student>> allStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> oneStudent(@PathVariable int studentId) throws ResourceNotFoundException {
	    Student foundStudent = studentService.getStudentById(studentId);
	
	    if (foundStudent == null) {
	    	throw new ResourceNotFoundException("No student id found with the id: " + studentId);
	    }
	
	    return new ResponseEntity<>(foundStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("{studentId}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int studentId) throws ResourceNotFoundException {
	    if (studentService.deleteStudentById(studentId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No student id found with the id: " + studentId);
	    }
	}
}
