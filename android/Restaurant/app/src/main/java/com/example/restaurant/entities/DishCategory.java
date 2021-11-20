package com.example.restaurant.entities;

import java.util.List;

public class DishCategory {

    private Long id;

    private String name;

    private String imagePath;

    private List<Dish> dishes;

    public DishCategory() {
    }

    public DishCategory(Long id, String name, String imagePath, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.dishes = dishes;
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
