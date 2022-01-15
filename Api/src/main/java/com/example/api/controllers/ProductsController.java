package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.errors.EntityNotFoundException;
import com.example.api.projections.ProductInfoCook;
import com.example.api.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductsController {
    private final ProductsRepository repository;

    @Autowired
    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("id/{id}")
    public ProductInfoCook findById(@PathVariable Long id) {
        return repository.findProductInfoCookById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    /**
     * Retrieve all the products from the database
     *
     * @return List of products
     */
    @GetMapping("all")
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    /**
     * Increase the quantity of given product by amount specified by quantity
     *
     * @param id       id of the product, quantity have to be increased
     * @param quantity amount of product which was delivered
     * @return Product with updated quantity
     */
    @PutMapping("/{id}/{quantity}")
    public Product increaseQuantity(@PathVariable Long id, @PathVariable Long quantity) {
        return repository.findById(id)
                .map(product -> {
                    if (product.getQuantity() != null)
                        product.setQuantity(product.getQuantity() + quantity);
                    return repository.save(product);
                })
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

}
