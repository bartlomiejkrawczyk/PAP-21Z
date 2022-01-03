package com.example.desktop.entities;

public class Ingredient {

    private Long id;

    private Long quantity;

    private Long dishId;

    private Long productId;

    public Ingredient() {
    }

    public Ingredient(Long id, Long quantity, Long dishId, Long productId) {
        this.id = id;
        this.quantity = quantity;
        this.dishId = dishId;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
