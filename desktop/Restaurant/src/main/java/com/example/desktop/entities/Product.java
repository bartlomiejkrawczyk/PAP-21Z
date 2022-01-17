package com.example.desktop.entities;

/**
 * Product is an entity that stores information about particular product
 * and how much of this product is in magazine
 * <p>
 * Furthermore, it stores minimum quantity
 * - when quantity drops below the minQuantity, there is dire need for new delivery
 * <p>
 * It is divided into categories
 */
public class Product {
    private Long id;

    private String name;

    private Long quantity;

    private Long minQuantity;

    private String unit;

    private Long productCategoryId;

    public Product(Long id, String name, Long quantity, Long minQuantity, String unit, Long productCategoryId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.unit = unit;
        this.productCategoryId = productCategoryId;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Long minQuantity) {
        this.minQuantity = minQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
