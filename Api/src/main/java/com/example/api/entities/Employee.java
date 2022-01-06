package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 63)
    private String firstName;

    @Column(name = "FAMILY_NAME", nullable = false)
    private String familyName;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "EMPLOYEE_KIND_ID", nullable = false)
//    private EmployeeKind employeeKind;

    @Column(name = "EMPLOYEE_KIND_ID", nullable = false)
    private Long employeeKindId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(familyName, employee.familyName)) return false;
        return Objects.equals(employeeKindId, employee.employeeKindId);
    }
}
