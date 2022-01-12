package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SpecialRequestTest {

    @Test
    public void testConstructor(){
        Long num1 = -7777777L;
        Long num2 = 666666L;

        SpecialRequest sr = new SpecialRequest(num1, "dej kamienia", num2);
        assertEquals(num1, sr.getId());
        assertEquals("dej kamienia", sr.getRequest());
        assertEquals(num2, sr.getOrderId());
    }

    @Test
    public void testSetters(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        SpecialRequest sr = new SpecialRequest(num1, "dej kamienia", num2);
        sr.setId(num3);
        sr.setRequest("dej amu");
        sr.setOrderId(num4);

        assertEquals(num3, sr.getId());
        assertEquals("dej amu", sr.getRequest());
        assertEquals(num4, sr.getOrderId());
    }
}
