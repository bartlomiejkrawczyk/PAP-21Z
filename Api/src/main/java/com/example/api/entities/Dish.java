package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

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
    private Long price;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "DISH_CATEGORY_ID", nullable = false)
//    private DishCategory dishCategory;

    @Column(name = "DISH_CATEGORY_ID", nullable = false)
    private Long dishCategoryId;

    @OneToMany(mappedBy = "dishId")
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "dishId")
    private List<Recipe> recipes;
}
