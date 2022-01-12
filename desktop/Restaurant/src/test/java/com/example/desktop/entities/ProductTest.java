package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void testConstructor(){
        Long num1 = -7777777L;
        Product prod = new Product(num1, "kau", "napoje");
        assertEquals(num1, prod.getId());
        assertEquals("kau", prod.getName());
        assertEquals("napoje", prod.getUnit());
    }

    @Test
    public void testSetters(){
        Long num1 = -7777777L;
        Long num2 = 666666L;

        Product prod = new Product(num1, "kau", "napoje");

        prod.setId(num2);
        prod.setName("schabowy");
        prod.setUnit("danie główne");

        assertEquals(num2, prod.getId());
        assertEquals("schabowy", prod.getName());
        assertEquals("danie główne", prod.getUnit());
    }
}
