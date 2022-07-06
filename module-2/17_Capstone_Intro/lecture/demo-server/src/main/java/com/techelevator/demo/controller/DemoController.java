package com.techelevator.demo.controller;

import com.techelevator.demo.exception.NotDepartmentHeadException;
import com.techelevator.demo.model.Department;
import com.techelevator.demo.model.Employee;
import com.techelevator.demo.service.DepartmentService;
import com.techelevator.demo.service.EmployeeService;
import com.techelevator.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class DemoController {

    private final UserService userService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DemoController(UserService userService, DepartmentService demoService,
                          EmployeeService employeeService) {
        this.userService = userService;
        this.departmentService = demoService;
        this.employeeService = employeeService;
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{deptId}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long deptId) {
        return employeeService.getEmployeesForDepartment(deptId);
    }

    @PostMapping("/departments/{deptId}/employees")
    public Employee createEmployee(@PathVariable Long deptId, @RequestBody Employee newEmployee) {
        return employeeService.createEmployee(newEmployee, deptId);
    }



}
