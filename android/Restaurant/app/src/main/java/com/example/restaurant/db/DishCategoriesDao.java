package com.example.restaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.restaurant.entities.DishCategory;

import java.util.List;

/**
 * Data Access Object
 * - interface used to define methods needed to operate on dish categories
 */
@Dao
public interface DishCategoriesDao {

    @Query("SELECT * FROM categories")
    List<DishCategory> getCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DishCategory category);
}
