package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testConstructor(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        Ingredient ing = new Ingredient(num1, num2, num3, num4);

        assertEquals(num1, ing.getId());
        assertEquals(num3, ing.getDishId());
        assertEquals(num4, ing.getProductId());
        assertEquals(num2, ing.getQuantity());
    }

    @Test
    public void testSetters(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        Ingredient ing = new Ingredient(num1, num2, num3, num4);

        ing.setId(num4);
        ing.setQuantity(num3);
        ing.setDishId(num2);
        ing.setProductId(num1);

        assertEquals(num4, ing.getId());
        assertEquals(num3, ing.getQuantity());
        assertEquals(num2, ing.getDishId());
        assertEquals(num1, ing.getProductId());
    }
}
