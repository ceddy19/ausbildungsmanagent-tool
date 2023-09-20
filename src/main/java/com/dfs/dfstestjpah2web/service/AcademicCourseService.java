package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.AcademicCourseRepository;
import com.dfs.dfstestjpah2web.entity.AcademicCourse;

@Service
public class AcademicCourseService {
	@Autowired
	private AcademicCourseRepository academicCourseRepository;

	public AcademicCourse createAcademicCourse(AcademicCourse academicCourse) {
		return academicCourseRepository.save(academicCourse);
	}
	
	public List<AcademicCourse> getAllAcademicCourses() {
		return academicCourseRepository.findAll();
	}
	
	public AcademicCourse getAcademicCourseById(int academicCourseId) {
		return academicCourseRepository.findById(academicCourseId).orElse(null);
	}
	
	public AcademicCourse updateAcademicCourse(AcademicCourse academicCourse, int academicCourseId) {
		AcademicCourse foundAcademicCourse = academicCourseRepository.findById(academicCourseId).orElse(null);
		if(foundAcademicCourse != null) {
			foundAcademicCourse.setName(academicCourse.getName());
			academicCourseRepository.save(foundAcademicCourse);
		}else {
			return null;
		}
		return foundAcademicCourse;
	}
	
	public boolean deleteAcademicCourseById(int academicCourseId) {
		AcademicCourse foundAcademicCourse = academicCourseRepository.findById(academicCourseId).orElse(null);
		if(foundAcademicCourse != null) {
			academicCourseRepository.deleteById(academicCourseId);
			return true;
		}else {
			return false;
		}
	}
}
