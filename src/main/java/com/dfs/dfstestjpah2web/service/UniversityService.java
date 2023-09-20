package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.UniversityRepository;
import com.dfs.dfstestjpah2web.entity.University;

@Service
public class UniversityService {
	@Autowired
	private UniversityRepository universityRepository;

	public University createUniversity(University university) {
		return universityRepository.save(university);
	}
	
	public List<University> getAllUniversities() {
		return universityRepository.findAll();
	}
	
	public University getUniversityById(int universityId) {
		return universityRepository.findById(universityId).orElse(null);
	}
	
	public University updateUniversity(University university, int universityId) {
		University foundUniversity = universityRepository.findById(universityId).orElse(null);
		if(foundUniversity != null) {
			foundUniversity.setName(university.getName());
			universityRepository.save(foundUniversity);
		}else {
			return null;
		}
		return foundUniversity;
	}
	
	public boolean deleteUniversityById(int universityId) {
		University foundUniversity = universityRepository.findById(universityId).orElse(null);
		if(foundUniversity != null) {
			universityRepository.deleteById(universityId);
			return true;
		}else {
			return false;
		}
	}
}
