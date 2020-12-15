package com.tcs.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organization {
	private Long ID;
	private String name;
	private String address;
	

	@OneToMany(mappedBy = "organization",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Department> departments = new ArrayList<Department>();

	@OneToMany(mappedBy = "organization",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Employee> employees = new ArrayList<Employee>();
	
}
