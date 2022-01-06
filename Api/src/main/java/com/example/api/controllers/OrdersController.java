package com.example.api.controllers;

import com.example.api.entities.Employee;
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
    public List<OrderInfoWaiter> findOrdersByReceipt(@PathVariable Long receipt) {
        return repository.findOrdersByReceiptId(receipt);
    }

    @GetMapping("/desktop/placed/{status}")
    public List<OrderInfoCook> findOrdersByStatusAndEmployeeIsNull(@PathVariable int status) {
        return repository.findByStatusAndEmployeeIsNull(status);
    }

    @GetMapping("/desktop/progress/{status}")
    public List<OrderInfoCook> findOrdersByStatusAndEmployeeIsNotNull(@PathVariable int status) {
        return repository.findByStatusAndEmployeeIsNotNull(status);
    }

    @PutMapping("/employee/{orderId}/{employeeId}")
    public Order setEmployee(@PathVariable Long orderId, @PathVariable Long employeeId) {
        return repository.findById(orderId)
                .map(order -> {
                    Employee employee = new Employee();
                    employee.setId(employeeId);
                    order.setEmployee(employee);
                    return repository.save(order);
                }).orElseThrow(() -> new EntityNotFoundException(orderId));
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

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
