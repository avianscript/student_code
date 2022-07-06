package com.techelevator.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate birthDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
