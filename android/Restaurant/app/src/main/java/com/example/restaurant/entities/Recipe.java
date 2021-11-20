package com.example.restaurant.entities;

public class Recipe {

    private Long step;

    private Long dishId;

    private String recipe;

    public Recipe() {
    }

    public Recipe(Long step, Long dishId, String recipe) {
        this.step = step;
        this.dishId = dishId;
        this.recipe = recipe;
    }

    public Long getStep() {
        return step;
    }

    public void setStep(Long step) {
        this.step = step;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
