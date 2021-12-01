package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Table(name = "EMPLOYEE_KINDS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeKind {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "employeeKindId")
    private List<Employee> employees;

}