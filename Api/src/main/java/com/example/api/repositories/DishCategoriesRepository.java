package com.example.api.repositories;

import com.example.api.entities.DishCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishCategoriesRepository extends CrudRepository<DishCategory, Long> {
}
