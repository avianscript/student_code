package com.techelevator.demo.dao;

import com.techelevator.demo.exception.DepartmentHeadNotFoundException;
import com.techelevator.demo.model.Department;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDepartmentDao implements DepartmentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Department> list() {
        List<Department> depts = new ArrayList<>();

        String sql = "SELECT * FROM department";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()) {
            Department dept = mapRowToDepartment(rowSet);
            depts.add(dept);
        }
        return depts;
    }

    @Override
    public Long getDepartmentOwnerId(Long deptId) throws DepartmentHeadNotFoundException {
        String sql = "SELECT department_head_id FROM department WHERE department_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Long.class, deptId);
        } catch (EmptyResultDataAccessException ex) {
            throw new DepartmentHeadNotFoundException("Unable to find department head for department " + deptId);
        }
    }

    @Override
    public void addEmployeeToDepartment(Long employeeId, Long deptId) {
        String sql = "INSERT INTO employee_department VALUES (?, ?)";
        jdbcTemplate.update(sql, employeeId, deptId);
    }


    private Department mapRowToDepartment(SqlRowSet row) {
        Long id = row.getLong("department_id");
        String name = row.getString("department_name");
        Long ownerId = row.getLong("department_head_id");
        return new Department(id, name, ownerId);
    }
}
