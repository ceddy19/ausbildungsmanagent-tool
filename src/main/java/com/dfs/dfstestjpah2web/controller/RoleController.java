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

import com.dfs.dfstestjpah2web.entity.Role;
import com.dfs.dfstestjpah2web.service.RoleService;

import dto.RoleDto;
import exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("")
	public ResponseEntity<Role> createRole(@Valid @RequestBody RoleDto createRoleDto) throws ResourceNotFoundException {
	    Role roleInput = createRoleDto.toRole();
	    Role createdRole = roleService.createRole(roleInput);
	
	    return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Role>> allRoles() {
		return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/{roleId}")
	public ResponseEntity<Role> oneRole(@PathVariable int roleId) throws ResourceNotFoundException {
	    Role foundRole = roleService.getRoleById(roleId);
	
	    if (foundRole == null) {
	    	throw new ResourceNotFoundException("No role id found with the id: " + roleId);
	    }
	
	    return new ResponseEntity<>(foundRole, HttpStatus.OK);
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<Role> updateRole(@PathVariable int roleId, @Valid @RequestBody RoleDto updateRoleDto) throws ResourceNotFoundException {
		Role roleInput = updateRoleDto.toRole();
	    Role updatedRole = roleService.updateRole(roleInput, roleId);
	    
	    if (updatedRole == null) {
	    	throw new ResourceNotFoundException("No role id found with the id: " + roleId);
	    }
	
	    return new ResponseEntity<>(updatedRole, HttpStatus.OK);
	}
	
	@DeleteMapping("{roleId}")
	public ResponseEntity<Role> deleteRole(@PathVariable int roleId) throws ResourceNotFoundException {
	    if (roleService.deleteRoleById(roleId)) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	    	throw new ResourceNotFoundException("No role id found with the id: " + roleId);
	    }
	}
}
