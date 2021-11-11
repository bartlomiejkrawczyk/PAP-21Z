package com.example.restaurant.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "examples")
public class ExampleEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String example;

    public ExampleEntity() {
    }
}
