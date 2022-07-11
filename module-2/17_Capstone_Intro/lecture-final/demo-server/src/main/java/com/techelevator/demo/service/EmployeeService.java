package com.techelevator.demo.service;

import com.techelevator.demo.dao.EmployeeDao;
import com.techelevator.demo.exception.NotDepartmentHeadException;
import com.techelevator.demo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeService {

    private EmployeeDao employeeDao;
    private DepartmentService departmentService;

    public EmployeeService(EmployeeDao employeeDao, DepartmentService departmentService) {
        this.employeeDao = employeeDao;
        this.departmentService = departmentService;
    }

    public List<Employee> getEmployeesForDepartment(Long deptId, String username) throws NotDepartmentHeadException {
        departmentService.validateDepartmentOwner(deptId, username);
        return employeeDao.getEmployeesForDepartment(deptId);
    }

    @Transactional
    public Employee createEmployee(Employee newEmployee, Long deptId, String username) throws NotDepartmentHeadException {
        Employee savedEmployee = employeeDao.createEmployee(newEmployee);
        if (savedEmployee != null) {
            departmentService.addEmployeeToDepartment(savedEmployee.getEmployeeId(), deptId, username);
        }
        return savedEmployee;
    }

}
