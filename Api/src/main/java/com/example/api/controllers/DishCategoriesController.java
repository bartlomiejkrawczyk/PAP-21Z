package com.example.api.controllers;

import com.example.api.entities.DishCategory;
import com.example.api.projections.DishCategoryInfo;
import com.example.api.repositories.DishCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/dishCategories")
@RestController
public class DishCategoriesController {
    private final DishCategoriesRepository repository;

    @Autowired
    public DishCategoriesController(DishCategoriesRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all Dish Categories from database
     *
     * @return List of all dish categories and dishes from those categories
     */
    @GetMapping("all")
    public List<DishCategory> findAll() {
        return (List<DishCategory>) repository.findAll();
    }

    /**
     * Retrieve only some information about all the Dish Categories from Database (where name is not null)
     *
     * @return List of all dish categories and dishes
     */
    @GetMapping("mobile")
    public List<DishCategoryInfo> findDishCategoriesInfo() {
        return repository.findByNameNotNull();
    }

    /**
     * Method to test the Spring Boot api
     *
     * @return Mock Dish Category
     */
    @GetMapping("example")
    public DishCategory getExample() {
        return new DishCategory(1L, "Category", "tomato.jpg", Collections.emptyList());
    }
}
