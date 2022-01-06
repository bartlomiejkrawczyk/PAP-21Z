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

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "DISH_ID", nullable = false)
//    private Dish dish;

    @Column(name = "DISH_ID", nullable = false)
    private Long dishId;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "PRODUCT_ID", nullable = false)
//    private Product product;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

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
