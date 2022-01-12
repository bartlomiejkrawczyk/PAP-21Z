package com.example.api.projections;

import java.util.List;

public interface DishCategoryInfo {
    Long getId();

    String getImagePath();

    String getName();

    List<DishInfo> getDishes();

    interface DishInfo {
        Long getId();

        Long getDishCategoryId();

        String getImagePath();

        String getName();

        Long getPrice();
    }
}
