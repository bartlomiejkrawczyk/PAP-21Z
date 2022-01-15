package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing available in restaurant positions
 * For now there are only two available positions
 * 1 - waiter
 * 2 - cook
 *
 * @see Employee
 */
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

    /**
     * Method used for test purposes
     *
     * @param o object to which this object will be compared
     * @return whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeKind that = (EmployeeKind) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }
}