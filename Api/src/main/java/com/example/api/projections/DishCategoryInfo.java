package com.example.api.projections;

import java.util.List;

/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.DishCategory
 */
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
