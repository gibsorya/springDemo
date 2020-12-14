package com.tcs.employee.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private Long ID;
	private Long organizationID;
	private String name;
	private List<Employee> employees = new ArrayList<Employee>();
	
}
