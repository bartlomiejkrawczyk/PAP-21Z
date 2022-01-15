package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Product is an entity that stores information about particular product
 * and how much of this product is in magazine
 * <p>
 * Furthermore it stores minimum quantity
 * - when quantity drops below the minQuantity, there is dire need for new delivery
 * <p>
 * It is divided into categories
 *
 * @see ProductCategory
 */
@Table(name = "PRODUCTS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 63)
    private String name;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "MIN_QUANTITY")
    private Long minQuantity;

    @Column(name = "UNIT", nullable = false, length = 10)
    private String unit;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false)
    private Long productCategoryId;

    /**
     * Method used for test purposes
     *
     * @param o object to which this object will be compared
     * @return whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(quantity, product.quantity)) return false;
        if (!Objects.equals(minQuantity, product.minQuantity)) return false;
        if (!Objects.equals(unit, product.unit)) return false;
        return Objects.equals(productCategoryId, product.productCategoryId);
    }
}
