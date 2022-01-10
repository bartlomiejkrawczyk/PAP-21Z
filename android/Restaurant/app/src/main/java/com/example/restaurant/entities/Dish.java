package com.example.restaurant.entities;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.restaurant.db.AppDatabase;

import java.io.Serializable;

@Entity(tableName = "dishes")
public class Dish implements Serializable {
    @PrimaryKey
    private Long id;

    private String name;
    private String imagePath;
    private Integer price;

    private Long dishCategoryId;


    public Dish() {
    }

    @Ignore
    public Dish(Long id) {
        this.id = id;
    }

    @Ignore
    public Dish(Long id, String name, String imagePath, Integer price, Long dishCategoryId) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.dishCategoryId = dishCategoryId;
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

    public void fetchData(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        Dish dish = db.dishesDao().getDishById(this.id);
        if (dish != null) {
            setName(dish.getName());
            setImagePath(dish.getImagePath());
            setPrice(dish.getPrice());
            setDishCategoryId(dish.getDishCategoryId());
        } else {
            setName("Not Found");
            setPrice(0);
            setDishCategoryId(0L);
        }
    }

}
