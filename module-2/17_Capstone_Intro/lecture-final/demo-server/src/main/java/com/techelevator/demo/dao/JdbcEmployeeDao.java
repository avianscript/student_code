package com.techelevator.demo.dao;


import com.techelevator.demo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEmployeeDao implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Employee> getEmployeesForDepartment(Long deptId) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee e\n" +
                "JOIN employee_department ed ON ed.employee_id = e.employee_id\n" +
                "JOIN department d ON d.department_id = ed.department_id\n" +
                "WHERE d.department_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, deptId);
        while (rowSet.next()) {
            Employee employee = mapRowToEmployee(rowSet);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee createEmployee(Employee newEmployee) {
        String sql = "INSERT INTO employee VALUES (DEFAULT, ?, ?, ?) RETURNING employee_id";
        Long employeeId = jdbcTemplate.queryForObject(sql, Long.class, newEmployee.getFirstName(), newEmployee.getLastName(),
                newEmployee.getBirthDate());
        newEmployee.setEmployeeId(employeeId);
        return newEmployee;
    }

    private Employee mapRowToEmployee(SqlRowSet row) {
        Long employeeId = row.getLong("employee_id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        LocalDate birthDate = row.getDate("birthdate").toLocalDate();
        Employee employee = new Employee(employeeId, firstName, lastName, birthDate);
        return employee;
    }
}
