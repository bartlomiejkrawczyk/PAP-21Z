package com.example.api.controllers;

import com.example.api.entities.ProductCategory;
import com.example.api.repositories.ProductCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/productCategories")
@RestController
public class ProductCategoriesController {
    private final ProductCategoriesRepository repository;

    @Autowired
    public ProductCategoriesController(ProductCategoriesRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all the product categories available in the database, with products included in categories
     *
     * @return List of all product categories
     */
    @GetMapping("all")
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) repository.findAll();
    }
}
