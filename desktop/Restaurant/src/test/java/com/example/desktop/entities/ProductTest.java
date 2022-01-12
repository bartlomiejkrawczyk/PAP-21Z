package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;

    @Test
    public void testConstructor(){
        Product prod = new Product((long) -7777777, "kau", "napoje");
        assertEquals(prod.getId(), num1);
        assertEquals(prod.getName(), "kau");
        assertEquals(prod.getUnit(), "napoje");
    }

    @Test
    public void testSetters(){
        Product prod = new Product((long) -7777777, "kau", "napoje");

        prod.setId((long) 666666);
        prod.setName("schabowy");
        prod.setUnit("danie główne");

        assertEquals(prod.getId(), num2);
        assertEquals(prod.getName(), "schabowy");
        assertEquals(prod.getUnit(), "danie główne");
    }
}
