package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishCategoryTest {

    @Test
    public void dishCategoryEmptyConstructor() {
        DishCategory dishCategory = new DishCategory();

        assertNull(dishCategory.getId());
        assertNull(dishCategory.getName());
        assertNull(dishCategory.getImagePath());
        assertNull(dishCategory.getDishes());
    }

    @Test
    public void dishCategoryConstructor() {
        List<Dish> dishes = new ArrayList<>();
        DishCategory dishCategory = new DishCategory(1L, "test", "file.png", dishes);

        assertEquals(Long.valueOf(1L), dishCategory.getId());
        assertEquals("test", dishCategory.getName());
        assertEquals("file.png", dishCategory.getImagePath());
        assertEquals(dishes, dishCategory.getDishes());
    }

    @Test
    public void dishCategorySetters() {
        DishCategory dishCategory = new DishCategory();

        dishCategory.setId(1L);
        dishCategory.setName("test");
        dishCategory.setImagePath("file.png");


        List<Dish> dishes = new ArrayList<>();
        dishCategory.setDishes(dishes);

        assertEquals(Long.valueOf(1L), dishCategory.getId());
        assertEquals("test", dishCategory.getName());
        assertEquals("file.png", dishCategory.getImagePath());
        assertEquals(dishes, dishCategory.getDishes());
    }

    @Test
    public void dishCategorySerialize() {
        List<Dish> dishes = Arrays.asList(
                new Dish(1L, "test", "file.png", 1234, 1L),
                new Dish(2L, null, null, 4321, 1L)
        );
        List<DishCategory> categories = Arrays.asList(
                new DishCategory(1L, "test", "file.png", dishes),
                new DishCategory(null, "test", "file.png", dishes),
                new DishCategory(1L, null, "file.png", dishes),
                new DishCategory(1L, "test", null, dishes),
                new DishCategory(1L, "test", "file.png", null),
                new DishCategory()
        );

        categories.forEach(category -> {
            try {
                DishCategory output = deserialize(serialize(category), DishCategory.class);

                assertEquals(category.getId(), output.getId());
                assertEquals(category.getName(), output.getName());
                assertEquals(category.getImagePath(), output.getImagePath());
                if (category.getDishes() != null) {
                    assertEquals(category.getDishes().size(), output.getDishes().size());
                    if (category.getDishes().size() > 0 && category.getDishes().get(0) != null)
                        assertEquals(category.getDishes().get(0).getId(), output.getDishes().get(0).getId());
                } else {
                    assertNull(output.getDishes());
                }
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }
}
