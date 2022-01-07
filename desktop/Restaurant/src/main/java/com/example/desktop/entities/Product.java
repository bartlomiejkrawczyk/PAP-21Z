package com.example.desktop.entities;

public class Product {
    private Long id;

    private String name;

    private String unit;

    public Product() {
        id = 0L;
        name = "";
        unit = "";
    }

    public Product(Long id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
