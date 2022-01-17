package com.example.desktop.entities;

/**
 * Employee represents an entity holding information about
 * particular worker
 * <p>
 * On desktop every employee has assigned position - 2 - cook
 */
public class Employee {

    private Long id;

    private String firstName;

    private String familyName;

    private Long employeeKindId;

    public Employee() {
    }

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
        if (firstName != null && familyName != null)
            return firstName + " " + familyName;
        else if (firstName != null)
            return firstName;
        else if (familyName != null)
            return familyName;
        return "Unnamed employee";
    }
}
