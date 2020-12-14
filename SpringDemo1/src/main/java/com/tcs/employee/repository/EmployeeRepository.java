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

import com.tcs.employee.model.Employee;
import com.tcs.employee.utils.DBUtils;

@Repository
public class EmployeeRepository {
	
	@Autowired
	DBUtils utils;
	
	public String addEmployee(Employee employee) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String newEmployee = "INSERT INTO Employee (ID, organizationID, departmentID, name, age, position) VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			statement = connection.prepareStatement(newEmployee);
			statement.setLong(1, employee.getID());
			statement.setLong(2, employee.getOrganizationID());
			statement.setLong(3, employee.getDepartmentID());
			statement.setString(4, employee.getName());
			statement.setInt(5, employee.getAge());
			statement.setString(6, employee.getPosition());
			
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

	public String updateEmployee(long ID) {
		String update = "";
		int newNum = 0, num = 0;
		Scanner input = new Scanner(System.in);
			do {
			
				System.out.println("What employee info you want to update?");
				System.out.println("1. Update their Organization ID");
				System.out.println("2. Update their Department ID");
				System.out.println("3. Update their name");
				System.out.println("4. Update their age");
				System.out.println("5. Update their position");
				System.out.println("0. Exit Program");
				
				num = input.nextInt();

				switch (newNum) {
				case 1:
					System.out.println("Insert new Org ID");
					update = updateOrgId(ID, input.nextLong());
					break;
				case 2:
					System.out.println("Insert new Dept ID");
					update = updateDeptId(ID, input.nextLong());
					break;
				case 3:
					System.out.println("Insert their new name");
					update = updateName(ID, input.next());
					break;
				case 4:
					System.out.println("Insert their new age");
					update = updateAge(ID, input.nextInt());
					break;
				case 5:
					System.out.println("Insert their new position");
					update = updatePosition(ID, input.next());
					break;
				}

			} while(num != 0);
			
			input.close();
			
			return update;
	}
	
	public String updateOrgId(long ID, long input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Employee SET OrgID = ? WHERE ID = " + ID;
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
	
	public String updateDeptId(long ID, long input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Employee SET DeptID = ? WHERE ID = " + ID;
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
	public String updateName(long ID, String input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Employee SET name = ? WHERE ID = " + ID;
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
	public String updateAge(long ID, int input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Employee SET age = ? WHERE ID = " + ID;
		int result = 0;
		try {
			statement = connection.prepareStatement(update);
			
			statement.setInt(1, input);
			result = statement.executeUpdate();

			if (result > 0) {
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
	public String updatePosition(long ID, String input) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String update = "UPDATE Employee SET position = ? WHERE ID = " + ID;
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

	public String deleteEmployee(long ID) {
		Connection connection = utils.getConnection();
		PreparedStatement statement = null;
		String delete = "DELETE FROM Employee WHERE ID = ?";
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
	
	public Optional<Employee> findById(long ID) {
		Connection connection = utils.getConnection();
		Employee employee = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Employee WHERE ID = ?";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setLong(1, ID);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				employee = new Employee();
				employee.setID(result.getLong("ID"));
				employee.setOrganizationID(result.getLong("organizationID"));
				employee.setDepartmentID(result.getLong("departmentID"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setPosition(result.getString("position"));
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
		return Optional.of(employee);
	}

	public Optional<List<Employee>> getEmployees() {
		Connection connection = utils.getConnection();
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Employee";
		
		try {
			statement = connection.prepareStatement(query);			
			result = statement.executeQuery();
			
			while(result.next()) {
				Employee employee = new Employee();
				employee.setID(result.getLong("ID"));
				employee.setOrganizationID(result.getLong("organizationID"));
				employee.setDepartmentID(result.getLong("departmentID"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setPosition(result.getString("position"));
				employees.add(employee);
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
		return Optional.of(employees);
	}

	public Optional<List<Employee>> findByOrganizationId(long ID) {
		Connection connection = utils.getConnection();
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet result = null;
		PreparedStatement statement = null;
		String query = "SELECT * FROM Employee WHERE organizationID = ?";
		
		try {
			statement = connection.prepareStatement(query);		
			statement.setLong(1, ID);
			result = statement.executeQuery();
			
			while(result.next()) {
				Employee employee = new Employee();
				employee.setID(result.getLong("ID"));
				employee.setOrganizationID(result.getLong("organizationID"));
				employee.setDepartmentID(result.getLong("departmentID"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setPosition(result.getString("position"));
				employees.add(employee);
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
		return Optional.of(employees);
	}
}
