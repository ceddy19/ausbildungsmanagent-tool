package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.SemesterRepository;
import com.dfs.dfstestjpah2web.entity.Semester;

@Service
public class SemesterService {
	@Autowired
	private SemesterRepository semesterRepository;

	public Semester createSemester(Semester semester) {
		return semesterRepository.save(semester);
	}
	
	public List<Semester> getAllSemesters() {
		return semesterRepository.findAll();
	}
	
	public Semester getSemesterById(int semesterId) {
		return semesterRepository.findById(semesterId).orElse(null);
	}
	
	public Semester updateSemester(Semester semester, int semesterId) {
		Semester foundSemester = semesterRepository.findById(semesterId).orElse(null);
		if(foundSemester != null) {
			foundSemester.setName(semester.getName());
			foundSemester.setStartDate(semester.getStartDate());
			foundSemester.setEndDate(semester.getEndDate());
			semesterRepository.save(foundSemester);
		}else {
			return null;
		}
		return foundSemester;
	}
	
	public boolean deleteSemesterById(int semesterId) {
		Semester foundSemester = semesterRepository.findById(semesterId).orElse(null);
		if(foundSemester != null) {
			semesterRepository.deleteById(semesterId);
			return true;
		}else {
			return false;
		}
	}
}
