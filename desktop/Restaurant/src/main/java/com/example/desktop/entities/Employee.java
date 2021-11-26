package com.example.desktop.entities;

public class Employee {

    private Long id;

    private String firstName;

    private String familyName;

    private Long employeeKindId;

    public Employee(Long id, String firstName, String familyName, Long employeeKindId) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.employeeKindId = employeeKindId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Long getEmployeeKindId() {
        return employeeKindId;
    }

    public void setEmployeeKindId(Long employeeKindId) {
        this.employeeKindId = employeeKindId;
    }

    @Override
    public String toString() {
        if (firstName != null)
            return firstName;
        return "Unnamed employee";
    }
}
