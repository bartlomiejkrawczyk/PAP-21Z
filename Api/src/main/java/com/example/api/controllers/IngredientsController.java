package com.example.api.controllers;

import com.example.api.entities.Ingredient;
import com.example.api.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ingredients")
@RestController
public class IngredientsController {
    private final IngredientsRepository repository;

    @Autowired
    public IngredientsController(IngredientsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Ingredient> findAll() {
        return (List<Ingredient>) repository.findAll();
    }

    @GetMapping("/dish/{dish}")
    public List<Ingredient> findIngredientsByDish(@PathVariable Long dish) {
        return repository.findIngredientsByDishId(dish);
    }

    @PostMapping
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@RequestBody Ingredient newIngredient, @PathVariable Long id) {
        return repository.findById(id)
                .map(ingredient -> {
                    ingredient.setDishId(newIngredient.getDishId());
                    ingredient.setProduct(newIngredient.getProduct());
                    ingredient.setQuantity(newIngredient.getQuantity());
                    return repository.save(ingredient);
                }).orElseGet(() -> {
                    newIngredient.setId(id);
                    return repository.save(newIngredient);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
