package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class EmployeeTest {

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;
    Long num3 = (long) 1;
    Long num4 = (long) 22;

    @Test
    public void testConstructor(){

        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        assertEquals(emp.getId(), num4);
        assertEquals(emp.getFirstName(), "Karol");
        assertEquals(emp.getFamilyName(), "Sulkowski");
        assertEquals(emp.getEmployeeKindId(), num3);
    }

    @Test
    public void testSetters(){
        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        emp.setId((long) -7777777);
        emp.setFirstName("Adam");
        emp.setFamilyName("Rogoziński");
        emp.setEmployeeKindId((long) 666666);

        assertEquals(emp.getId(), num1);
        assertEquals(emp.getFirstName(), "Adam");
        assertSame(emp.getFamilyName(), "Rogoziński");
        assertEquals(emp.getEmployeeKindId(), num2);
    }

    @Test
    public void testToString(){
        Employee emp = new Employee((long) 22, "Karol", "Sulkowski", (long) 1);
        assertEquals(emp.toString(), "Karol Sulkowski");

        emp.setFirstName(null);
        assertEquals(emp.toString(), "Sulkowski");

    }
}
