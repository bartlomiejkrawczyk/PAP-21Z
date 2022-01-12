package com.example.desktop.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Vector;

public class DishTest {

    Ingredient ing1 = new Ingredient((long) -7777777, (long) 666666, (long) 1, (long) 22);
    Ingredient ing2 = new Ingredient((long) 22, (long) 1, (long) 666666, (long) -7777777);

    Long num1 = (long) -7777777;
    Long num2 = (long) 666666;
    Long num3 = (long) 1;
    Long num4 = (long) 22;

    Recipe rec1 = new Recipe(1, "it certainly is", 22);
    Recipe rec2 = new Recipe(666666);



    @Test
    public void testConstructor(){

        List<Ingredient> ingList = new Vector<>();

        ingList.add(ing1);
        ingList.add(ing2);

        List<Recipe> recList = new Vector<>();

        recList.add(rec1);
        recList.add(rec2);

        Dish d = new Dish((long) -7777777, "lama", "dir1/dir2/file.jpg",
                22, (long) 666666, ingList, recList);

        assertEquals(d.getId(), num1);
        assertEquals(d.getName(), "lama");
        assertEquals(d.getImagePath(), "dir1/dir2/file.jpg");
        assertEquals(d.getPrice(), (Integer) 22);
        assertEquals(d.getDishCategoryId(), num2);
        assertEquals(d.getIngredients().get(1).getId(), num4);
        assertEquals(d.getRecipes().get(0).getRecipe(), "it certainly is");
    }

    @Test
    public void testSetters(){
        List<Ingredient> ingList = new Vector<>();

        ingList.add(ing1);
        ingList.add(ing2);

        List<Recipe> recList = new Vector<>();

        recList.add(rec1);
        recList.add(rec2);

        Dish d = new Dish((long) -7777777, "lama", "dir1/dir2/file.jpg",
                22, (long) 666666, ingList, recList);

        ingList.remove(0);
        recList.remove(0);

        d.setId((long) 1);
        d.setName("nielama");
        d.setImagePath("dir/file.jpg");
        d.setPrice(22);
        d.setDishCategoryId((long) -7777777);
        d.setIngredients(ingList);
        d.setRecipes(recList);

        assertEquals(d.getId(), num3);
        assertEquals(d.getName(), "nielama");
        assertEquals(d.getImagePath(), "dir/file.jpg");
        assertEquals(d.getPrice(), (Integer) 22);
        assertEquals(d.getDishCategoryId(), num1);
        assertEquals(d.getIngredients().get(0).getId(), num4);
        assertEquals(d.getRecipes().get(0).getDishId(), 666666);

    }
}
