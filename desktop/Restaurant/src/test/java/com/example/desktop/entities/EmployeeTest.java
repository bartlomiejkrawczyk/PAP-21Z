package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class EmployeeTest {

    @Test
    public void testConstructor(){
        Long num3 = (long) 1;
        Long num4 = (long) 22;

        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        assertEquals(num4, emp.getId());
        assertEquals("Karol", emp.getFirstName());
        assertEquals("Sulkowski", emp.getFamilyName());
        assertEquals(num3, emp.getEmployeeKindId());
    }

    @Test
    public void testSetters(){
        Long num1 = (long) -7777777;
        Long num2 = (long) 666666;

        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        emp.setId(num1);
        emp.setFirstName("Adam");
        emp.setFamilyName("Rogoziński");
        emp.setEmployeeKindId((long) num2);

        assertEquals(num1, emp.getId());
        assertEquals("Adam", emp.getFirstName());
        assertSame("Rogoziński", emp.getFamilyName());
        assertEquals(num2, emp.getEmployeeKindId());
    }

    @Test
    public void testToString(){
        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        assertEquals("Karol Sulkowski", emp.toString());

        emp.setFirstName(null);
        assertEquals("Sulkowski", emp.toString());

        emp.setFamilyName(null);
        assertEquals("Unnamed employee", emp.toString());

        Employee emp2 = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        emp2.setFamilyName(null);
        assertEquals("Karol", emp2.toString());
    }
}
