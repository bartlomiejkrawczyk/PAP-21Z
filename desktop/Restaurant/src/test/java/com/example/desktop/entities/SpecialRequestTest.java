package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SpecialRequestTest {

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;
    Long num3 = (long) 1;
    Long num4 = (long) 22;

    @Test
    public void testConstructor(){
        SpecialRequest sr = new SpecialRequest((long) -7777777, "dej kamienia", (long) 666666);
        assertEquals(sr.getId(), num1);
        assertEquals(sr.getRequest(), "dej kamienia");
        assertEquals(sr.getOrderId(), num2);
    }

    @Test
    public void testSetters(){
        SpecialRequest sr = new SpecialRequest((long) -7777777, "dej kamienia", (long) 666666);
        sr.setId((long) 1);
        sr.setRequest("dej amu");
        sr.setOrderId((long) 22);

        assertEquals(sr.getId(), num3);
        assertEquals(sr.getRequest(), "dej amu");
        assertEquals(sr.getOrderId(), num4);
    }
}
