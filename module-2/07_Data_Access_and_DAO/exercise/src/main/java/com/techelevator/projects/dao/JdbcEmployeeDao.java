package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employee WHERE first_name ILIKE ? AND  last_name ILIKE ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		return new ArrayList<>();
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}


	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();

		employee.setId(result.getInt("employee_id"));
		// finish this...

		return employee;
	}


}
