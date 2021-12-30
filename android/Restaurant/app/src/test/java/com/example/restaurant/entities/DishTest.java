package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DishTest {

    @Test
    public void dishEmptyConstructor() {
        Dish dish = new Dish();

        assertNull(dish.getId());
        assertNull(dish.getName());
        assertNull(dish.getImagePath());
        assertNull(dish.getPrice());
        assertNull(dish.getDishCategoryId());
    }

    @Test
    public void dishPartialConstructor() {
        Dish dish = new Dish(1L);

        assertEquals(Long.valueOf(1L), dish.getId());
        assertNull(dish.getName());
        assertNull(dish.getImagePath());
        assertNull(dish.getPrice());
        assertNull(dish.getDishCategoryId());
    }

    @Test
    public void dishConstructor() {
        Dish dish = new Dish(1L, "test", "file.png", 1234, 1L);

        assertEquals(Long.valueOf(1L), dish.getId());
        assertEquals("test", dish.getName());
        assertEquals("file.png", dish.getImagePath());
        assertEquals(Integer.valueOf(1234), dish.getPrice());
        assertEquals(Long.valueOf(1L), dish.getDishCategoryId());
    }

    @Test
    public void dishFetchData() {

    }

    @Test
    public void dishSerialize() {
        List<Dish> dishes = Arrays.asList(
                new Dish(1L, "test", "file.png", 1234, 1L),
                new Dish(null, "test", "file.png", 1234, 1L),
                new Dish(1L, null, "file.png", 1234, 1L),
                new Dish(1L, "test", null, 1234, 1L),
                new Dish(1L, "test", "file.png", null, 1L),
                new Dish(1L, "test", "file.png", 1234, null),
                new Dish()
        );

        dishes.forEach(dish -> {
            try {
                Dish output = deserialize(serialize(dish), Dish.class);

                assertEquals(dish.getId(), output.getId());
                assertEquals(dish.getName(), output.getName());
                assertEquals(dish.getImagePath(), output.getImagePath());
                assertEquals(dish.getPrice(), output.getPrice());
                assertEquals(dish.getDishCategoryId(), output.getDishCategoryId());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }


}
