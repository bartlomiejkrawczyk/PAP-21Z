package com.example.restaurant.entities;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Employee implements Serializable {

    private Long id;

    private String name;


    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(Long id, String name) {
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
        if (name != null)
            return name;
        return "Employee";
    }
}
