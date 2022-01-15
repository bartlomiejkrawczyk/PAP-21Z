package com.example.api.repositories;

import com.example.api.entities.DishCategory;
import com.example.api.projections.DishCategoryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see DishCategory
 */
@Repository
public interface DishCategoriesRepository extends CrudRepository<DishCategory, Long> {

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @return List of information about dishCategories
     * @see DishCategoryInfo
     */
    List<DishCategoryInfo> findByNameNotNull();
}
