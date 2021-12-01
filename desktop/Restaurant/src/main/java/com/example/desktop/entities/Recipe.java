package com.example.desktop.entities;

public class Recipe {
    private int step;
    private int dishId;
    private String recipe;

    public int getStep() { return step; }

    public void setStep(int step)  {this.step = step; }

    public int getDishId() {return dishId;}

    public void setDishId(int dishId) {this.dishId = dishId;}

    public String getRecipe() {return recipe;}

    public void setRecipe(String recipe) {this.recipe = recipe;}

    public Recipe(int step, int dishId, String recipe){
        this.step = step;
        this.dishId = dishId;
        this.recipe = recipe;
    }


}
