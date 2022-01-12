package com.example.restaurant.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tables")
public class Table implements Serializable {

    @PrimaryKey
    private Long id;

    private String name;

    public Table() {
    }

    @Ignore
    public Table(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @NonNull
    @Override
    public String toString() {
        if (name != null && id != null)
            return id + " - " + name;
        else if (name != null)
            return name;
        return "Table";
    }
}
