package com.tcs.employee.service;

import com.tcs.employee.model.Employee;
import com.tcs.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public String addEmployee(Employee employee) {
		return employeeRepo.addEmployee(employee);
	}

	public String updateEmployee(long ID) {
		return employeeRepo.updateEmployee(ID);
	}

	public String deleteEmployee(long ID) {
		return employeeRepo.deleteEmployee(ID);
	}
	
	public Optional<Employee> findById(long ID) {
		return employeeRepo.findById(ID);
	}

	public Optional<List<Employee>> getEmployees() {
		return employeeRepo.getEmployees();
	}

	public Optional<List<Employee>> findByOrganizationId(long ID) {
		return employeeRepo.findByOrganizationId(ID);
	}
}
