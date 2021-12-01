package com.example.api.controllers;

import com.example.api.entities.Recipe;
import com.example.api.entities.RecipeId;
import com.example.api.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recipes")
@RestController
public class RecipesController {
    private final RecipesRepository repository;

    @Autowired
    public RecipesController(RecipesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Recipe> findAll() {
        return (List<Recipe>) repository.findAll();
    }

    @GetMapping("/dish/{dish}")
    public List<Recipe> findRecipesByDish(@PathVariable Long dish) {
        return repository.findRecipesByDishId(dish);
    }

    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }

    @PutMapping("/{step}")
    public Recipe updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Long step) {
        return repository.findById(new RecipeId(step, newRecipe.getDishId()))
                .map(recipe -> {
                    recipe.setRecipe(newRecipe.getRecipe());
                    return repository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setStep(step);
                    return repository.save(newRecipe);
                });
    }

    @DeleteMapping("/{dishId}")
    public void deleteRecipes(@PathVariable Long dishId) {
        repository.deleteByDishId(dishId);
    }
}
