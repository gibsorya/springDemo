package com.tcs.employee.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
	private Long ID;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<Department>();
	private List<Employee> employees = new ArrayList<Employee>();
	
}
