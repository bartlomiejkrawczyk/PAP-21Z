package com.example.desktop.entities;

public class Cook extends Employee {
    private Integer id;
    private String name;

    public Cook() {
    }

    public Cook (Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getIdInt() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
