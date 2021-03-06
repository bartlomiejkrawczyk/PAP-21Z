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
 * Entity that connects two other entities
 * - Dish
 * - Product
 * <p>
 * Ingredient holds information about how much of that product is needed to prepare a dish
 *
 * @see Dish
 * @see Product
 */
@Entity
@Table(name = "INGREDIENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "DISH_ID", nullable = false)
    private Long dishId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

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

        Ingredient that = (Ingredient) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(quantity, that.quantity)) return false;
        if (!Objects.equals(dishId, that.dishId)) return false;
        return Objects.equals(productId, that.productId);
    }

}
