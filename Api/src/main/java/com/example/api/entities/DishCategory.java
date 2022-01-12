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
@Table(name = "DISH_CATEGORIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishCategory {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 63)
    private String name;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @OneToMany(mappedBy = "dishCategoryId")
    private List<Dish> dishes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishCategory category = (DishCategory) o;

        if (!Objects.equals(id, category.id)) return false;
        if (!Objects.equals(name, category.name)) return false;
        return Objects.equals(imagePath, category.imagePath);
    }
}
