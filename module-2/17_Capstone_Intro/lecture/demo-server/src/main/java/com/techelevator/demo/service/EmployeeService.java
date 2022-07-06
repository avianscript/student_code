package com.techelevator.demo.service;

import com.techelevator.demo.dao.EmployeeDao;
import com.techelevator.demo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    private EmployeeDao employeeDao;
    private DepartmentService departmentService;

    public EmployeeService(EmployeeDao employeeDao, DepartmentService departmentService) {
        this.employeeDao = employeeDao;
        this.departmentService = departmentService;
    }

    public List<Employee> getEmployeesForDepartment(Long deptId) {
        return employeeDao.getEmployeesForDepartment(deptId);
    }

    public Employee createEmployee(Employee newEmployee, Long deptId) {
        Employee savedEmployee = employeeDao.createEmployee(newEmployee);
        if (savedEmployee != null) {
            departmentService.addEmployeeToDepartment(savedEmployee.getEmployeeId(), deptId);
        }
        return savedEmployee;
    }

}
