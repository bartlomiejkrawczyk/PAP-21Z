package com.example.restaurant.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

/**
 * Entity used to divide dishes into categories
 *
 * @see Dish
 */
@Entity(tableName = "categories")
public class DishCategory implements Serializable {

    @PrimaryKey
    private Long id;

    private String name;

    @ColumnInfo(name = "image_path")
    private String imagePath;

    @Ignore
    private List<Dish> dishes;

    public DishCategory() {
    }

    @Ignore
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
