package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.ProjectTypeRepository;
import com.dfs.dfstestjpah2web.entity.ProjectType;

@Service
public class ProjectTypeService {
	@Autowired
	private ProjectTypeRepository projectTypeRepository;

	public ProjectType createProjectType(ProjectType projectType) {
		return projectTypeRepository.save(projectType);
	}
	
	public List<ProjectType> getAllProjectTypes() {
		return projectTypeRepository.findAll();
	}
	
	public ProjectType getProjectTypeById(int id) {
		return projectTypeRepository.findById(id).orElse(null);
	}
	
	public ProjectType updateProjectType(ProjectType projectType, int projectTypeId) {
		ProjectType foundprojectType = projectTypeRepository.findById(projectTypeId).orElse(null);
		if(foundprojectType != null) {
			foundprojectType.setName(projectType.getName());
			projectTypeRepository.save(foundprojectType);
		}else {
			return null;
		}
		return foundprojectType;
	}
	
	public boolean deleteProjectTypeById(int projectTypeId) {
		ProjectType foundprojectType = projectTypeRepository.findById(projectTypeId).orElse(null);
		if(foundprojectType != null) {
			projectTypeRepository.deleteById(projectTypeId);
			return true;
		}else {
			return false;
		}
	}
}
