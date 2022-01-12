package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecipeTest {
    @Test
    public void testBiggerConstructor(){
        Recipe rec = new Recipe(2, "it certainly is", 10);
        assertEquals(rec.getDishId(), 2);
        assertEquals(rec.getRecipe(), "it certainly is");
        assertEquals(rec.getStep(), 10);
    }

    @Test
    public void testSmallerConstructor(){
        Recipe rec = new Recipe(8);
        assertEquals(rec.getStep(), 0);
        assertEquals(rec.getRecipe(), "");
        assertEquals(rec.getDishId(), 8);
    }

    @Test
    public void testExtendRecipe(){
        Recipe rec = new Recipe(8, "pierwsza linia", 2);
        rec.extendRecipe("");
        rec.extendRecipe("druga linia");
        rec.extendRecipe("trzecia linia");

        String recStr = "pierwsza linia";
        recStr = recStr + "\n" + "druga linia" + "\n" + "trzecia linia" + "\n";

        assertEquals(rec.getRecipe(), recStr);
    }

    @Test
    public void testGettersSetters(){
        Recipe rec = new Recipe(94, "not recipe", 27);
        rec.setRecipe("definitely not recipe");
        rec.setDishId(27);
        rec.setStep(94);
        assertEquals(rec.getRecipe(), "definitely not recipe");
        assertEquals(rec.getStep(), 94);
        assertEquals(rec.getDishId(), 27);
    }
}
