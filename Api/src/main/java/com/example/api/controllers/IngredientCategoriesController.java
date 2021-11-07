package com.example.api.controllers;

import com.example.api.entities.IngredientCategory;
import com.example.api.repositories.IngredientCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/ingredient_categories")
public class IngredientCategoriesController {
    private final IngredientCategoriesRepository repository;

    @Autowired
    public IngredientCategoriesController(IngredientCategoriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<IngredientCategory> findAll() {
        return (List<IngredientCategory>) repository.findAll();
    }
}
