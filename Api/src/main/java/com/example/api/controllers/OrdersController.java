package com.example.api.controllers;

import com.example.api.entities.Order;
import com.example.api.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrdersController {
    private final OrdersRepository repository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository) {
        this.repository = ordersRepository;
    }

    @GetMapping("all")
    public List<Order> findAll() {
        return repository.findAllActive();
    }
}
