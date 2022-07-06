package com.techelevator.demo.model;

import java.util.Objects;

public class Department {

    private Long departmentId;
    private String departmentName;
    private Long departmentHeadId;

    public Department(Long departmentId, String departmentName, Long departmentHeadId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHeadId = departmentHeadId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Long getDepartmentHeadId() {
        return departmentHeadId;
    }

}
