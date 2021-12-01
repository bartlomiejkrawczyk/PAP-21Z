package com.example.desktop.entities;

public class Cook {
    private Long id;
    private String name;

    public Cook() {
    }

    public Cook(String name) {
        this.name = name;
    }

    public Cook (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
