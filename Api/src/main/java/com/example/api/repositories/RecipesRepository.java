package com.example.api.repositories;

import com.example.api.entities.Recipe;
import com.example.api.entities.RecipeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see Recipe
 */
@Repository
public interface RecipesRepository extends CrudRepository<Recipe, RecipeId> {
}
