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

import com.dfs.dfstestjpah2web.entity.AcademicCourse;
import com.dfs.dfstestjpah2web.service.AcademicCourseService;

import dto.AcademicCourseDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/course")
public class AcademicCourseController {
	@Autowired
	private AcademicCourseService academicCourseService;

	@PostMapping("")
	public ResponseEntity<AcademicCourse> createAcademicCourse(@Valid @RequestBody AcademicCourseDto createAcademicCourseDto) throws ResourceNotFoundException {
		AcademicCourse academicCourseInput = createAcademicCourseDto.toAcademicCourse();
		AcademicCourse createdAcademicCourse = academicCourseService.createAcademicCourse(academicCourseInput);
	
	    return new ResponseEntity<>(createdAcademicCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<AcademicCourse>> allAcademicCourses() {
		return new ResponseEntity<>(academicCourseService.getAllAcademicCourses(), HttpStatus.OK);
	}
	
	@GetMapping("/{academicCourseId}")
	public ResponseEntity<AcademicCourse> oneRole(@PathVariable int academicCourseId) throws ResourceNotFoundException {
		AcademicCourse foundAcademicCourse = academicCourseService.getAcademicCourseById(academicCourseId);
	
	    if (foundAcademicCourse == null) {
	    	throw new ResourceNotFoundException("No academic course id found with the id: " + academicCourseId);
	    }
	
	    return new ResponseEntity<>(foundAcademicCourse, HttpStatus.OK);
	}
	
	@PutMapping("/{academicCourseId}")
	public ResponseEntity<AcademicCourse> updateAcademicCourse(@PathVariable int academicCourseId, @Valid @RequestBody AcademicCourseDto updateAcademicCourseDto) throws ResourceNotFoundException {
		AcademicCourse academicCourseInput = updateAcademicCourseDto.toAcademicCourse();
		AcademicCourse updatedAcademicCourse = academicCourseService.updateAcademicCourse(academicCourseInput, academicCourseId);
	    
	    if (updatedAcademicCourse == null) {
	    	throw new ResourceNotFoundException("No academic course id found with the id: " + academicCourseId);
	    }
	
	    return new ResponseEntity<>(updatedAcademicCourse, HttpStatus.OK);
	}
	
	@DeleteMapping("{academicCourseId}")
	public ResponseEntity<AcademicCourse> deleteRole(@PathVariable int academicCourseId) throws ResourceNotFoundException {
	    if (academicCourseService.deleteAcademicCourseById(academicCourseId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No academic course id found with the id: " + academicCourseId);
	    }
	}
}
