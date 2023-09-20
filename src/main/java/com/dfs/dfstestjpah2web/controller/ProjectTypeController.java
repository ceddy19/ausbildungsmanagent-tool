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

import com.dfs.dfstestjpah2web.entity.ProjectType;
import com.dfs.dfstestjpah2web.service.ProjectTypeService;

import dto.ProjectTypeDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/projecttype")
public class ProjectTypeController {
	@Autowired
	private ProjectTypeService projectTypeService;

	@PostMapping("")
	public ResponseEntity<ProjectType> createProjectType(@Valid @RequestBody ProjectTypeDto createProjectTypeDto) throws ResourceNotFoundException {
	    ProjectType projectTypeInput = createProjectTypeDto.toProjectType();
	    ProjectType createdProjectType = projectTypeService.createProjectType(projectTypeInput);
	
	    return new ResponseEntity<>(createdProjectType, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<ProjectType>> allProjectTypes() {
		return new ResponseEntity<>(projectTypeService.getAllProjectTypes(), HttpStatus.OK);
	}
	
	@GetMapping("/{projectTypeId}")
	public ResponseEntity<ProjectType> oneProjectType(@PathVariable int projectTypeId) throws ResourceNotFoundException {
	    ProjectType foundProjectType = projectTypeService.getProjectTypeById(projectTypeId);
	
	    if (foundProjectType == null) {
	    	throw new ResourceNotFoundException("No projectType id found with the id: " + projectTypeId);
	    }
	
	    return new ResponseEntity<>(foundProjectType, HttpStatus.OK);
	}
	
	@PutMapping("/{projectTypeId}")
	public ResponseEntity<ProjectType> updateProjectType(@PathVariable int projectTypeId, @Valid @RequestBody ProjectTypeDto updateProjectTypeDto) throws ResourceNotFoundException {
		ProjectType projectTypeInput = updateProjectTypeDto.toProjectType();
	    ProjectType updatedProjectType = projectTypeService.updateProjectType(projectTypeInput, projectTypeId);
	    
	    if (updatedProjectType == null) {
	    	throw new ResourceNotFoundException("No projectType id found with the id: " + projectTypeId);
	    }
	
	    return new ResponseEntity<>(updatedProjectType, HttpStatus.OK);
	}
	
	@DeleteMapping("{projectTypeId}")
	public ResponseEntity<ProjectType> deleteProjectType(@PathVariable int projectTypeId) throws ResourceNotFoundException {
	    if (projectTypeService.deleteProjectTypeById(projectTypeId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No projectType id found with the id: " + projectTypeId);
	    }
	}
}
