package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void testConstructor(){
        Long num1 = -7777777L;
        Long num2 = 123123L;
        Long num3 = 11L;
        Long num4 = 2131L;

        Product prod = new Product(num1, "Piwko", num2, num3, "cysterny", num4);

        assertEquals(num1, prod.getId());
        assertEquals("Piwko", prod.getName());
        assertEquals(num2, prod.getQuantity());
        assertEquals(num3, prod.getMinQuantity());
        assertEquals("cysterny", prod.getUnit());
        assertEquals(num4, prod.getProductCategoryId());
    }

    @Test
    public void testSetters() {
        Long num1 = -7777777L;
        Long num2 = 123123L;
        Long num3 = 11L;
        Long num4 = 2131L;

        Long num5 = -7453L;
        Long num6 = 7234232L;
        Long num7 = 11234L;
        Long num8 = 2333L;

        Product prod = new Product(num1, "Piwko", num2, num3, "cysterny", num4);

        prod.setId(num5);
        prod.setName("schabowy");
        prod.setQuantity(num6);
        prod.setMinQuantity(num7);
        prod.setUnit("g");
        prod.setProductCategoryId(num8);

        assertEquals(num5, prod.getId());
        assertEquals("schabowy", prod.getName());
        assertEquals(num6, prod.getQuantity());
        assertEquals(num7, prod.getMinQuantity());
        assertEquals("g", prod.getUnit());
        assertEquals(num8, prod.getProductCategoryId());
    }
}
