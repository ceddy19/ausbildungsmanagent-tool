package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.StudentRepository;
import com.dfs.dfstestjpah2web.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student updateStudent(Student student, int studentId) {
		Student foundstudent = studentRepository.findById(studentId).orElse(null);
		if(foundstudent != null) {
			foundstudent.setName(student.getName());
			studentRepository.save(foundstudent);
		}else {
			return null;
		}
		return foundstudent;
	}
	
	public boolean deleteStudentById(int studentId) {
		Student foundstudent = studentRepository.findById(studentId).orElse(null);
		if(foundstudent != null) {
			studentRepository.deleteById(studentId);
			return true;
		}else {
			return false;
		}
	}
}
