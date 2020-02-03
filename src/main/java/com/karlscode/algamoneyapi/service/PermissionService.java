package com.karlscode.algamoneyapi.service;

import com.karlscode.algamoneyapi.model.Permission;
import com.karlscode.algamoneyapi.repository.PermissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;
	
	public List<Permission> getAll() {
		return permissionRepository.findAll();
	}
	
	public Permission getById(Long id) {
		return findPermissionById(id);
	}
	
	public Permission save(Permission permission) {
		return permissionRepository.save(permission);
	}
	
	public Permission update(Long id, Permission permission) {
		Permission savePermission = findPermissionById(id);

		BeanUtils.copyProperties(permission, savePermission, "id");
		return permissionRepository.save(savePermission); 
	}
	
	public void delete(Long id) {
		findPermissionById(id);
		permissionRepository.deleteById(id);
	}
	
	private Permission findPermissionById(Long id) {
		return permissionRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}
