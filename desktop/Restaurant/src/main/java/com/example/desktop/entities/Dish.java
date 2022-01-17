package com.example.desktop.entities;

import java.util.List;

/**
 * Entity that holds information about the dish
 */
public class Dish {
    private Long id;
    private String name;
    private String imagePath;
    private Integer price;
    private Long dishCategoryId;

    private List<Ingredient> ingredients;

    private List<Recipe> recipes;

    public Dish() {
    }

    public Dish(Long id, String name, String imagePath, Integer price, Long dishCategoryId,
                List<Ingredient> ingredients, List<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.dishCategoryId = dishCategoryId;
        this.ingredients = ingredients;
        this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getDishCategoryId() {
        return dishCategoryId;
    }

    public void setDishCategoryId(Long dishCategoryId) {
        this.dishCategoryId = dishCategoryId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
