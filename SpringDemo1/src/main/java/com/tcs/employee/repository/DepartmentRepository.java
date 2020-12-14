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

import com.tcs.employee.model.Department;
import com.tcs.employee.utils.DBUtils;

@Repository
public class DepartmentRepository {

	@Autowired
	DBUtils utils;

	public String addDepartment(Department department) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String newDepartment = "INSERT INTO Department (ID, organizationID, name) VALUES(?,?,?)";
		int result = 0;

		try {
			statement = connection.prepareStatement(newDepartment);
			statement.setLong(1, department.getID());
			statement.setLong(2, department.getOrganizationID());
			statement.setString(3, department.getName());

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

	public String updateDepartment(long ID) {
		String update = "";
		int newNum = 0, num = 0;
		Scanner input = new Scanner(System.in);
		do {

			System.out.println("What department info do you want to update?");
			System.out.println("1. Update their Organization ID");
			System.out.println("2. Update their name");
			System.out.println("0. Exit Program");

			num = input.nextInt();

			switch (newNum) {
			case 1:
				System.out.println("Insert new Org ID");
				update = updateOrgId(ID, input.nextLong());
				break;
			case 2:
				System.out.println("Insert their new name");
				update = updateName(ID, input.next());
				break;

			}
		} while (num != 0);

		input.close();

		return update;
	}

	public String updateOrgId(long ID, long input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Department SET OrgID = ? WHERE ID = " + ID;
		int result = 0;
		try {
			statement = connection.prepareStatement(update);

			statement.setLong(1, input);
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

	public String updateName(long ID, String input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Department SET name = ? WHERE ID = " + ID;
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

	public String deleteDepartment(long ID) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String delete = "DELETE FROM Department WHERE ID = ?";
		int result = 0;

		try {
			statement = connection.prepareStatement(delete);
			statement.setLong(1, ID);

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

	public Optional<Department> findById(long ID) {
		Connection connection = utils.getConnection();
		Department department = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Department WHERE ID = ?";

		try {
			statement = connection.prepareStatement(query);
			statement.setLong(1, ID);

			result = statement.executeQuery();

			if (result.next()) {
				department = new Department();
				department.setID(result.getLong("ID"));
				department.setOrganizationID(result.getLong("organizationID"));
				department.setName(result.getString("name"));
			}
		} catch (SQLException e) {
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
		return Optional.of(department);
	}

	public Optional<List<Department>> getDepartments() {
		Connection connection = utils.getConnection();
		List<Department> departments = new ArrayList<Department>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Department";

		try {
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			while (result.next()) {
				Department department = new Department();
				department.setID(result.getLong("ID"));
				department.setOrganizationID(result.getLong("organizationID"));
				department.setName(result.getString("name"));
				departments.add(department);
			}
		} catch (SQLException e) {
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
		return Optional.of(departments);
	}

	public Optional<List<Department>> findByOrganizationId(long ID) {
		Connection connection = utils.getConnection();
		List<Department> departments = new ArrayList<Department>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Department WHERE organizationID = ?";

		try {
			statement = connection.prepareStatement(query);
			statement.setLong(1, ID);
			result = statement.executeQuery();

			while (result.next()) {
				Department department = new Department();
				department.setID(result.getLong("ID"));
				department.setOrganizationID(result.getLong("organizationID"));
				department.setName(result.getString("name"));
				departments.add(department);
			}
		} catch (SQLException e) {
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
		return Optional.of(departments);
	}
}
