package com.tcs.employee.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long ID;
	private Long organizationID;
	private Long departmentID;
	private String name;
	private int age;
	private String position;
	
}
