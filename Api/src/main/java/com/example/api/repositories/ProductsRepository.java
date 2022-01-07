package com.example.api.repositories;

import com.example.api.entities.Product;
import com.example.api.projections.ProductInfoCook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {

    Optional<ProductInfoCook> findProductInfoCookById(Long id);
}
