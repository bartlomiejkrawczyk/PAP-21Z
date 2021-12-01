package com.example.api.repositories;

import com.example.api.entities.DishCategory;
import com.example.api.projections.DishCategoryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishCategoriesRepository extends CrudRepository<DishCategory, Long> {

    List<DishCategoryInfo> findByNameNotNull();
}
