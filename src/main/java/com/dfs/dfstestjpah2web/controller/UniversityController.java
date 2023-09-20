package com.dfs.dfstestjpah2web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.dfstestjpah2web.entity.University;
import com.dfs.dfstestjpah2web.service.UniversityService;

import dto.UniversityDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/university")
public class UniversityController {
	@Autowired
	private UniversityService universityService;

	@PostMapping("")
	public ResponseEntity<University> createUniversity(@Valid @RequestBody UniversityDto createUniversityDto) throws ResourceNotFoundException {
		University universityInput = createUniversityDto.toUniversity();
		University createdUniversity = universityService.createUniversity(universityInput);
	
	    return new ResponseEntity<>(createdUniversity, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<University>> allUniversitys() {
		return new ResponseEntity<>(universityService.getAllUniversities(), HttpStatus.OK);
	}
	
	@GetMapping("/{universityId}")
	public ResponseEntity<University> oneUniversity(@PathVariable int universityId) throws ResourceNotFoundException {
	    University foundUniversity = universityService.getUniversityById(universityId);
	
	    if (foundUniversity == null) {
	    	throw new ResourceNotFoundException("No university id found with the id: " + universityId);
	    }
	
	    return new ResponseEntity<>(foundUniversity, HttpStatus.OK);
	}
	
	@PutMapping("/{universityId}")
	public ResponseEntity<University> updateUniversity(@PathVariable int universityId, @Valid @RequestBody UniversityDto updateUniversityDto) throws ResourceNotFoundException {
		University universityInput = updateUniversityDto.toUniversity();
	    University updatedUniversity = universityService.updateUniversity(universityInput, universityId);
	    
	    if (updatedUniversity == null) {
	    	throw new ResourceNotFoundException("No university id found with the id: " + universityId);
	    }
	
	    return new ResponseEntity<>(updatedUniversity, HttpStatus.OK);
	}
	
	@DeleteMapping("{universityId}")
	public ResponseEntity<University> deleteUniversity(@PathVariable int universityId) throws ResourceNotFoundException {
	    if (universityService.deleteUniversityById(universityId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No university id found with the id: " + universityId);
	    }
	}
}
