package com.example.restaurant.entities;

public class Ingredient {

    private Long id;

    private Long quantity;

    private Long dishId;

    private Product product;

    public Ingredient() {
    }

    public Ingredient(Long id, Long quantity, Long dishId, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.dishId = dishId;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
