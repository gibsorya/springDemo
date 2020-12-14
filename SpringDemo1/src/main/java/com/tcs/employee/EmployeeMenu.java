package com.tcs.employee;

import java.util.Scanner;

import com.tcs.employee.model.Employee;
import com.tcs.employee.service.EmployeeService;

public class EmployeeMenu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		do {
			EmployeeService service = new EmployeeService();
			
			System.out.println("Select what you want to do by inputing the number");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Find Employee by ID");
			System.out.println("5. Get All Employees");
			System.out.println("6. Find Employees by Organization ID");
			System.out.println("0. Exit Program");
			
			num = input.nextInt();
			long ID = 0;
			switch(num) {
			case 1:
				Employee employee = new Employee();
				System.out.println("Set their ID");
				employee.setID(input.nextLong());
				System.out.println("What is their Organization ID");
				employee.setOrganizationID(input.nextLong());
				System.out.println("What is their Department ID");
				employee.setDepartmentID(input.nextLong());
				System.out.println("What is their name");
				employee.setName(input.next());
				System.out.println("What is their age");
				employee.setAge(input.nextInt());
				System.out.println("What is their position");
				employee.setPosition(input.next());
				service.addEmployee(employee);
				break;
			case 2:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.updateEmployee(ID);
				break;
			case 3:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.deleteEmployee(ID);
				break;
			case 4:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.findById(ID);
				break;
			case 5:
				service.getEmployees();
				break;
			case 6:
				System.out.println("What Organization ID?");
				ID = input.nextLong();
				service.findByOrganizationId(ID);
				break;
			}
		} while(num != 0);
		
		input.close();
	}

}
