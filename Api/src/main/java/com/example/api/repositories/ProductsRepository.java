package com.example.api.repositories;

import com.example.api.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {

    List<Product> findProductsByProductCategoryId(Long productCategoryId);
}
