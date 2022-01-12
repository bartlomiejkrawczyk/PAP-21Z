package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest {

    @Test
    public void employeeEmptyConstructor() {
        Employee employee = new Employee();

        assertNull(employee.getId());
        assertNull(employee.getName());
    }

    @Test
    public void employeeConstructor() {
        Employee employee = new Employee(1L, "Bartłomiej Krawczyk");

        assertEquals(Long.valueOf(1L), employee.getId());
        assertEquals("Bartłomiej Krawczyk", employee.getName());
    }

    @Test
    public void employeePartialConstructor() {
        Employee employee = new Employee(1L);

        assertEquals(Long.valueOf(1L), employee.getId());
        assertNull(employee.getName());
    }

    @Test
    public void employeeToString() {
        Employee employee = new Employee(1L, "Bartłomiej Krawczyk");

        assertEquals("Bartłomiej Krawczyk", employee.toString());

        employee.setName(null);

        assertEquals("Employee", employee.toString());
    }

    @Test
    public void employeeSerialize() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Bartłomiej Krawczyk"),
                new Employee(1L, null),
                new Employee(null, "Bartłomiej Krawczyk"),
                new Employee()
        );

        employees.forEach(employee -> {
            try {
                Employee output = deserialize(serialize(employee), Employee.class);

                assertEquals(employee.getId(), output.getId());
                assertEquals(employee.getName(), output.getName());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }
}
