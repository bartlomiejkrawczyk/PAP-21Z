package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Vector;

public class DishTest {

    @Test
    public void testConstructor(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        Ingredient ing1 = new Ingredient(num1, num2, num3, num4);
        Ingredient ing2 = new Ingredient(num4, num3, num2, num1);

        Recipe rec1 = new Recipe(1, "it certainly is", 22);
        Recipe rec2 = new Recipe(666666);

        List<Ingredient> ingList = new Vector<>();

        ingList.add(ing1);
        ingList.add(ing2);

        List<Recipe> recList = new Vector<>();

        recList.add(rec1);
        recList.add(rec2);

        Dish d = new Dish(-7777777L, "lama", "dir1/dir2/file.jpg",
                22, 666666L, ingList, recList);

        assertEquals(num1, d.getId());
        assertEquals("lama", d.getName());
        assertEquals("dir1/dir2/file.jpg", d.getImagePath());
        assertEquals((Integer) 22, d.getPrice());
        assertEquals(num2, d.getDishCategoryId());
        assertEquals(num4, d.getIngredients().get(1).getId());
        assertEquals("it certainly is", d.getRecipes().get(0).getRecipe());
    }

    @Test
    public void testSetters(){
        Long num1 = -7777777L;
        Long num2 = 666666L;
        Long num3 = 1L;
        Long num4 = 22L;

        Ingredient ing1 = new Ingredient(num1, num2, num3, num4);
        Ingredient ing2 = new Ingredient(num4, num3, num2, num1);

        Recipe rec1 = new Recipe(1, "it certainly is", 22);
        Recipe rec2 = new Recipe(666666);

        List<Ingredient> ingList = new Vector<>();

        ingList.add(ing1);
        ingList.add(ing2);

        List<Recipe> recList = new Vector<>();

        recList.add(rec1);
        recList.add(rec2);

        Dish d = new Dish(num1, "lama", "dir1/dir2/file.jpg",
                22, num2, ingList, recList);

        ingList.remove(0);
        recList.remove(0);

        d.setId((long) 1);
        d.setName("nielama");
        d.setImagePath("dir/file.jpg");
        d.setPrice(22);
        d.setDishCategoryId((long) -7777777);
        d.setIngredients(ingList);
        d.setRecipes(recList);

        assertEquals(num3, d.getId());
        assertEquals("nielama", d.getName());
        assertEquals("dir/file.jpg", d.getImagePath());
        assertEquals((Integer) 22, d.getPrice());
        assertEquals(num1, d.getDishCategoryId());
        assertEquals(num4, d.getIngredients().get(0).getId());
        assertEquals(666666, d.getRecipes().get(0).getDishId());

    }
}
