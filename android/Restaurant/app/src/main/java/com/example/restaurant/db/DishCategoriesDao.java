package com.example.restaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.restaurant.entities.DishCategory;

import java.util.List;

@Dao
public interface DishCategoriesDao {

    @Query("SELECT * FROM categories")
    List<DishCategory> getCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DishCategory category);
}
