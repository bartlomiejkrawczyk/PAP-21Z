package com.example.api.repositories;

import com.example.api.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findIngredientsByDishId(Long dishId);
}
