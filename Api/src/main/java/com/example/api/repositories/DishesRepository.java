package com.example.api.repositories;

import com.example.api.entities.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepository extends CrudRepository<Dish, Long> {
}
