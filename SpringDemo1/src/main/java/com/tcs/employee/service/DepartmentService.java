package com.tcs.employee.service;

import com.tcs.employee.model.Department;
import com.tcs.employee.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	public String addDepartment(Department department) {
		return departmentRepo.addDepartment(department);
	}

	public String updateDepartment(long ID) {
		return departmentRepo.updateDepartment(ID);
	}

	public String deleteDepartment(long ID) {
		return departmentRepo.deleteDepartment(ID);
	}
	
	public Optional<Department> findById(long ID) {
		return departmentRepo.findById(ID);
	}

	public Optional<List<Department>> getDepartments() {
		return departmentRepo.getDepartments();
	}

	public Optional<List<Department>> findByOrganizationId(long ID) {
		return departmentRepo.findByOrganizationId(ID);
	}
}
