package com.example.api.controllers;

import com.example.api.entities.Dish;
import com.example.api.errors.EntityNotFoundException;
import com.example.api.repositories.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dishes")
@RestController
public class DishesController {
    private final DishesRepository repository;

    @Autowired
    public DishesController(DishesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Dish> findAll() {
        return (List<Dish>) repository.findAll();
    }

    @GetMapping("/{id}")
    public Dish findDishById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PostMapping
    public Dish saveDish(@RequestBody Dish dish) {
        return repository.save(dish);
    }

    @PutMapping("/{id}")
    public Dish updateDish(@RequestBody Dish newDish, @PathVariable Long id) {
        return repository.findById(id)
                .map(dish -> {
                    dish.setName(newDish.getName());
                    dish.setDishCategoryId(newDish.getDishCategoryId());
                    dish.setImagePath(newDish.getImagePath());
                    dish.setPrice(newDish.getPrice());
                    return repository.save(dish);
                })
                .orElseGet(() -> {
                    newDish.setId(id);
                    return repository.save(newDish);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
