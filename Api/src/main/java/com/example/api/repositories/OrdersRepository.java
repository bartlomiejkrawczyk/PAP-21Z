package com.example.api.repositories;

import com.example.api.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM ORDERS", nativeQuery = true)
    List<Order> findAllActive();
}
