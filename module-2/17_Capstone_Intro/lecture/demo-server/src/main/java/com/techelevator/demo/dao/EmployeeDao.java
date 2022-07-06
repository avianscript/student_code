package com.techelevator.demo.dao;

import com.techelevator.demo.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeesForDepartment(Long deptId);

    Employee createEmployee(Employee newEmployee);
}
