package com.tcs.employee;

import java.util.Scanner;

import com.tcs.employee.model.Department;
import com.tcs.employee.service.DepartmentService;

public class DepartmentMenu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		do {
			DepartmentService service = new DepartmentService();
			
			System.out.println("Select what you want to do by inputing the number");
			System.out.println("1. Add Department");
			System.out.println("2. Update Department");
			System.out.println("3. Delete Department");
			System.out.println("4. Find Department by ID");
			System.out.println("5. Get All Departments");
			System.out.println("6. Find Departments by Organization ID");
			System.out.println("0. Exit Program");
			
			num = input.nextInt();
			long ID = 0;
			switch(num) {
			case 1:
				Department Department = new Department();
				System.out.println("Set their ID");
				Department.setID(input.nextLong());
				System.out.println("What is their Organization ID");
				Department.setOrganizationID(input.nextLong());
				System.out.println("What is their name");
				Department.setName(input.next());
				service.addDepartment(Department);
				break;
			case 2:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.updateDepartment(ID);
				break;
			case 3:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.deleteDepartment(ID);
				break;
			case 4:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.findById(ID);
				break;
			case 5:
				service.getDepartments();
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
