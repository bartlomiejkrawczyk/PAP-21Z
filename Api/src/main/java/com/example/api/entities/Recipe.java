package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.Objects;

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

    @Id
    @Column(name = "DISH_ID", nullable = false)
    private Long dishId;

    @Column(name = "RECIPE")
    private String recipe;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe1 = (Recipe) o;

        if (!Objects.equals(step, recipe1.step)) return false;
        if (!Objects.equals(dishId, recipe1.dishId)) return false;
        return Objects.equals(recipe, recipe1.recipe);
    }

}
