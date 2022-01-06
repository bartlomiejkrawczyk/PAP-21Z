package com.example.api.controllers;

import com.example.api.entities.Recipe;
import com.example.api.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
