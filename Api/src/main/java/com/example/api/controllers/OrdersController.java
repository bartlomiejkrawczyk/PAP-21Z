package com.example.api.controllers;

import com.example.api.entities.Order;
import com.example.api.errors.EntityNotFoundException;
import com.example.api.projections.OrderInfoCook;
import com.example.api.projections.OrderInfoWaiter;
import com.example.api.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrdersController {
    private final OrdersRepository repository;

    @Autowired
    public OrdersController(OrdersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }

    @GetMapping("/receipt/{receipt}")
    public List<OrderInfoWaiter> findOrdersByReceipt(@PathVariable Long receipt) { //TODO: refactor this to retrieve only OrderInfoWaiter
        return repository.findOrdersByReceiptId(receipt);
    }

    @GetMapping("/status/{status}")
    public List<OrderInfoCook> findOrdersByStatus(@PathVariable int status) {
        return repository.findByStatus(status);
    }

    @PutMapping("/status/{orderId}/{status}")
    public Order advanceStatus(@PathVariable Long orderId, @PathVariable int status) {
        return repository.findById(orderId)
                .map(order -> {
                    int previous = order.getStatus();
                    if (previous < status) {
                        order.setStatus(status);
                        return repository.save(order);
                    }
                    return order;
                }).orElseThrow(() -> new EntityNotFoundException(orderId));
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return repository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return repository.findById(id)
                .map(order -> {
                    order.setDate(null);
                    order.setReceiptId(newOrder.getReceiptId());
                    order.setDish(newOrder.getDish());
                    return repository.save(order);
                }).orElseGet(() -> {
                    newOrder.setId(id);
                    return repository.save(newOrder);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
