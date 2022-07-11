package com.techelevator.demo.dao;

import com.techelevator.demo.exception.DepartmentHeadNotFoundException;
import com.techelevator.demo.model.Department;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface DepartmentDao {

    List<Department> list();

    Long getDepartmentOwnerId(Long deptId) throws DepartmentHeadNotFoundException;

    void addEmployeeToDepartment(Long employeeId, Long deptId);
}
