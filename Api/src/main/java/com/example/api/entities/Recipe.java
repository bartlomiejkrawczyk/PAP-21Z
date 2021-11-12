package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "RECIPES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RecipeId.class)
public class Recipe {

    @Id
    @Column(name = "STEP", nullable = false)
    private Long step;

//    @Id
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "DISH_ID", nullable = false)
//    private Dish dish;

    @Id
    @Column(name = "DISH_ID", nullable = false)
    private Long dishId;

    @Column(name = "RECIPE")
    private String recipe;

}
