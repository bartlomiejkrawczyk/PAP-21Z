package com.example.api.repositories;

import com.example.api.entities.IngredientCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCategoriesRepository extends CrudRepository<IngredientCategory, Long> {
}
