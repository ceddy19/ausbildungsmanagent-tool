package com.dfs.dfstestjpah2web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import com.dfs.dfstestjpah2web.entity.Semester;
import com.dfs.dfstestjpah2web.service.SemesterService;

import dto.SemesterDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/semester")
public class SemesterController {
	@Autowired
	private SemesterService semesterService;

	@PostMapping("")
	public ResponseEntity<Semester> createSemester(@Valid @RequestBody SemesterDto createSemesterDto) throws ResourceNotFoundException {
		
		// Convert start Date
		final Date startDateDate;
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(createSemesterDto.getStartDate());
			startDateDate = new Date(date.getTime()); 
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// Convert end Date
		final Date endDateDate;
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(createSemesterDto.getStartDate());
			endDateDate = new Date(date.getTime()); 
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
				
	    Semester semesterInput = createSemesterDto.toSemester(startDateDate, endDateDate);
	    Semester createdSemester = semesterService.createSemester(semesterInput);
	
	    return new ResponseEntity<>(createdSemester, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Semester>> allSemesters() {
		return new ResponseEntity<>(semesterService.getAllSemesters(), HttpStatus.OK);
	}
	
	@GetMapping("/{semesterId}")
	public ResponseEntity<Semester> oneSemester(@PathVariable int semesterId) throws ResourceNotFoundException {
	    Semester foundSemester = semesterService.getSemesterById(semesterId);
	
	    if (foundSemester == null) {
	    	throw new ResourceNotFoundException("No semester id found with the id: " + semesterId);
	    }
	
	    return new ResponseEntity<>(foundSemester, HttpStatus.OK);
	}
	
	@PutMapping("/{semesterId}")
	public ResponseEntity<Semester> updateSemester(@PathVariable int semesterId, @Valid @RequestBody SemesterDto updateSemesterDto) throws ResourceNotFoundException {
		// Convert start Date
		final Date startDateDate;
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(updateSemesterDto.getStartDate());
			startDateDate = new Date(date.getTime()); 
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// Convert end Date
		final Date endDateDate;
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(updateSemesterDto.getStartDate());
			endDateDate = new Date(date.getTime()); 
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
				
	    Semester semesterInput = updateSemesterDto.toSemester(startDateDate, endDateDate);
	    Semester updatedSemester = semesterService.updateSemester(semesterInput, semesterId);
	    
	    if (updatedSemester == null) {
	    	throw new ResourceNotFoundException("No semester id found with the id: " + semesterId);
	    }
	
	    return new ResponseEntity<>(updatedSemester, HttpStatus.OK);
	}
	
	@DeleteMapping("{semesterId}")
	public ResponseEntity<Semester> deleteSemester(@PathVariable int semesterId) throws ResourceNotFoundException {
	    if (semesterService.deleteSemesterById(semesterId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No semester id found with the id: " + semesterId);
	    }
	}
}
