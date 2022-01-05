package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;
    Long num3 = (long) 1;
    Long num4 = (long) 22;

    @Test
    public void testConstructor(){
        Ingredient ing = new Ingredient((long) -7777777, (long) 666666, (long) 1, (long) 22);
        assertEquals(ing.getId(), num1);
        assertEquals(ing.getDishId(), num3);
        assertEquals(ing.getProductId(), num4);
        assertEquals(ing.getQuantity(), num2);
    }

    @Test
    public void testSetters(){
        Ingredient ing = new Ingredient((long) -7777777, (long) 666666, (long) 1, (long) 22);
        ing.setId((long) 22);
        ing.setQuantity((long) 1);
        ing.setDishId((long) 666666);
        ing.setProductId((long) -7777777);

        assertEquals(ing.getId(), num4);
        assertEquals(ing.getQuantity(), num3);
        assertEquals(ing.getDishId(), num2);
        assertEquals(ing.getProductId(), num1);
    }
}
