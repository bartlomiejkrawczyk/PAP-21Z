package com.example.restaurant.db;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.restaurant.entities.ExampleEntity;

import java.util.List;

@Dao
public interface ExampleDao {

    @Query("SELECT * FROM examples")
    List<ExampleEntity> getExamples();
}
