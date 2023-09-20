package com.dfs.dfstestjpah2web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.RoleRepository;
import com.dfs.dfstestjpah2web.entity.Role;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	
	public Role getRoleById(int id) {
		return roleRepository.findById(id).orElse(null);
	}
	
	public Role updateRole(Role role, int roleId) {
		Role foundrole = roleRepository.findById(roleId).orElse(null);
		if(foundrole != null) {
			foundrole.setName(role.getName());
			roleRepository.save(foundrole);
		}else {
			return null;
		}
		return foundrole;
	}
	
	public boolean deleteRoleById(int roleId) {
		Role foundrole = roleRepository.findById(roleId).orElse(null);
		if(foundrole != null) {
			roleRepository.deleteById(roleId);
			return true;
		}else {
			return false;
		}
	}
}
