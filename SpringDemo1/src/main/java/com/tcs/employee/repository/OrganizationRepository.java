package com.tcs.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employee.model.Organization;
import com.tcs.employee.utils.DBUtils;

@Repository
public class OrganizationRepository {
	
	@Autowired
	DBUtils utils;
	
	public String addOrganization(Organization organization) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String newOrganization = "INSERT INTO Organization (ID, name, address) VALUES(?,?,?)";
		int result = 0;
		
		try {
			statement = connection.prepareStatement(newOrganization);
			statement.setLong(1, organization.getID());
			statement.setString(2, organization.getName());
			statement.setString(3, organization.getAddress());
			result = statement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "Success!";
			} else {
				return "Failed.";
			}
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Failed.";
		} finally {
			utils.closeConnection(connection);
		}
	}

	public String updateOrganization(long ID) {
		String update = "";
		int newNum = 0, num = 0;
		Scanner input = new Scanner(System.in);
		do {

			System.out.println("What organization info do you want to update?");
			System.out.println("1. Update their name");
			System.out.println("2. Update their address");
			System.out.println("0. Exit Program");

			num = input.nextInt();

			switch (newNum) {
			case 1:
				System.out.println("Insert their new name");
				update = updateName(ID, input.next());
				break;

			}
		} while (num != 0);

		input.close();

		return update;
	}

	public String updateName(long ID, String input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Organization SET name = ? WHERE ID = " + ID;
		int result = 0;
		try {
			statement = connection.prepareStatement(update);

			statement.setString(1, input);
			result = statement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "Success!";
			} else {
				return "Failed.";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Failed.";
		} finally {
			utils.closeConnection(connection);
		}
	}
	
	public String updateAddress(long ID, String input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Organization SET address = ? WHERE ID = " + ID;
		int result = 0;
		try {
			statement = connection.prepareStatement(update);

			statement.setString(1, input);
			result = statement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "Success!";
			} else {
				return "Failed.";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Failed.";
		} finally {
			utils.closeConnection(connection);
		}
	}

	public String deleteOrganization(long ID) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String delete = "DELETE FROM Organization WHERE ID = ?";
		int result = 0;
		
		try {
			statement = connection.prepareStatement(delete);
			statement.setLong(1, ID);
			
			result = statement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "Success!";
			} else {
				return "Failed.";
			}
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Failed.";
		} finally {
			utils.closeConnection(connection);
		}
	}
	
	public Optional<Organization> findById(long ID) {
		Connection connection = utils.getConnection();
		Organization organization = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Organization WHERE ID = ?";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setLong(1, ID);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				organization = new Organization();
				organization.setID(result.getLong("ID"));
				organization.setName(result.getString("name"));
				organization.setAddress(result.getString("address"));
			} 
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		} finally {
			utils.closeConnection(connection);
		}
		return Optional.of(organization);
	}

	public Optional<List<Organization>> getOrganizations() {
		Connection connection = utils.getConnection();
		List<Organization> organizations = new ArrayList<Organization>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Organization";
		
		try {
			statement = connection.prepareStatement(query);			
			result = statement.executeQuery();
			
			while(result.next()) {
				Organization organization = new Organization();
				organization.setID(result.getLong("ID"));
				organization.setName(result.getString("name"));
				organization.setAddress(result.getString("address"));
				organizations.add(organization);
			} 
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		} finally {
			utils.closeConnection(connection);
		}
		return Optional.of(organizations);
	}

	public Optional<List<Organization>> findByOrganizationId(long ID) {
		Connection connection = utils.getConnection();
		List<Organization> organizations = new ArrayList<Organization>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Organization WHERE organizationID = ?";
		
		try {
			statement = connection.prepareStatement(query);		
			statement.setLong(1, ID);
			result = statement.executeQuery();
			
			while(result.next()) {
				Organization organization = new Organization();
				organization.setID(result.getLong("ID"));
				organization.setName(result.getString("name"));
				organization.setAddress(result.getString("address"));
				organizations.add(organization);
			} 
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		} finally {
			utils.closeConnection(connection);
		}
		return Optional.of(organizations);
	}
}
