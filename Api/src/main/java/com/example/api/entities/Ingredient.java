package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

}
