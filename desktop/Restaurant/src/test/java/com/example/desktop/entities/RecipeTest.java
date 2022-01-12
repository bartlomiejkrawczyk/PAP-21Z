package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecipeTest {
    @Test
    public void testBiggerConstructor(){
        Recipe rec = new Recipe(2, "it certainly is", 10);
        assertEquals(2, rec.getDishId());
        assertEquals("it certainly is", rec.getRecipe());
        assertEquals(10, rec.getStep());
    }

    @Test
    public void testSmallerConstructor(){
        Recipe rec = new Recipe(8);
        assertEquals(0, rec.getStep());
        assertEquals("", rec.getRecipe());
        assertEquals(8, rec.getDishId());
    }

    @Test
    public void testExtendRecipe(){
        Recipe rec = new Recipe(8, "pierwsza linia", 2);
        rec.extendRecipe("");
        rec.extendRecipe("druga linia");
        rec.extendRecipe("trzecia linia");

        String recStr = "pierwsza linia";
        recStr = recStr + "\n" + "druga linia" + "\n" + "trzecia linia" + "\n";

        assertEquals(recStr, rec.getRecipe());
    }

    @Test
    public void testGettersSetters(){
        Recipe rec = new Recipe(94, "not recipe", 27);
        rec.setRecipe("definitely not recipe");
        rec.setDishId(27);
        rec.setStep(94);
        assertEquals("definitely not recipe", rec.getRecipe());
        assertEquals(94, rec.getStep());
        assertEquals(27, rec.getDishId());
    }
}
