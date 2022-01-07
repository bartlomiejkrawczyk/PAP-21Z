package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DISHES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 63)
    private String name;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "DISH_CATEGORY_ID", nullable = false)
    private Long dishCategoryId;

    @OneToMany(mappedBy = "dishId")
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "dishId")
    private List<Recipe> recipes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (!Objects.equals(id, dish.id)) return false;
        if (!Objects.equals(name, dish.name)) return false;
        if (!Objects.equals(imagePath, dish.imagePath)) return false;
        if (!Objects.equals(price, dish.price)) return false;
        return Objects.equals(dishCategoryId, dish.dishCategoryId);
    }

}
