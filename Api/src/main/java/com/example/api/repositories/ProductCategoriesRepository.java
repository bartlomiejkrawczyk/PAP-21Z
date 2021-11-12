package com.example.api.repositories;

import com.example.api.entities.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository extends CrudRepository<ProductCategory, Long> {
}
