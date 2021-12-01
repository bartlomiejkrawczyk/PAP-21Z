package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductsController {
    private final ProductsRepository repository;

    @Autowired
    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Product> findProductsByCategory(@PathVariable Long category) {
        return repository.findProductsByProductCategoryId(category);
    }
}
