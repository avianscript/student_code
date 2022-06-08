package com.techelevator;

import java.time.LocalDate;
import java.util.Objects;

public class DemoPerson {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String ssn;

    public DemoPerson(String firstName, String lastName, LocalDate birthDate, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoPerson that = (DemoPerson) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, ssn);
    }

    @Override
    public String toString() {
        return "DemoPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
