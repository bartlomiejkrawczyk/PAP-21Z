package com.example.desktop.entities;

public class Cook extends Employee {
    private Integer id_int;
    private String name;

    public Cook() {
    }

    public Cook (Integer id, String name) {
        this.id_int = id;
        this.name = name;
    }

    public Integer getIdInt() { return this.id_int; }
    public void setId(Integer id) { this.id_int = id; }

    public String getFirstName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
