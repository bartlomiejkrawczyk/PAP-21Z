package com.example.restaurant.entities;

import java.util.List;

public class Dish {
    private Long id;

    private String name;
    private String imagePath;
    private Long price;

    private Long dishCategoryId;
    private List<Ingredient> ingredients;

    private List<Recipe> recipes;
}
