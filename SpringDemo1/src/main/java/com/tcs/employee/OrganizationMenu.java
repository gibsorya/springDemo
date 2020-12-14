package com.tcs.employee;

import java.util.Scanner;

import com.tcs.employee.model.Organization;
import com.tcs.employee.service.OrganizationService;

public class OrganizationMenu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		do {
			OrganizationService service = new OrganizationService();
			
			System.out.println("Select what you want to do by inputing the number");
			System.out.println("1. Add Organization");
			System.out.println("2. Update Organization");
			System.out.println("3. Delete Organization");
			System.out.println("4. Find Organization by ID");
			System.out.println("5. Get All Organizations");
			System.out.println("6. Find Organizations by Organization ID");
			System.out.println("0. Exit Program");
			
			num = input.nextInt();
			long ID = 0;
			switch(num) {
			case 1:
				Organization Organization = new Organization();
				System.out.println("Set their ID");
				Organization.setID(input.nextLong());
				System.out.println("What is their name");
				Organization.setName(input.next());
				System.out.println("What is their address");
				Organization.setAddress(input.next());
				service.addOrganization(Organization);
				break;
			case 2:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.updateOrganization(ID);
				break;
			case 3:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.deleteOrganization(ID);
				break;
			case 4:
				System.out.println("What is their ID?");
				ID = input.nextLong();
				service.findById(ID);
				break;
			case 5:
				service.getOrganizations();
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
