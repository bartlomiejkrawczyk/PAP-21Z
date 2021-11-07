package com.example.api.controllers;

import com.example.api.entities.Ingredient;
import com.example.api.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ingredients")
@RestController
public class IngredientsController {
    private final IngredientsRepository repository;

    @Autowired
    public IngredientsController(IngredientsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Ingredient> findAll() {
        return (List<Ingredient>) repository.findAll();
    }
}
