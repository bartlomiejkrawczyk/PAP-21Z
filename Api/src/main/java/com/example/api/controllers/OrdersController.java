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

    /**
     * Retrieve all the orders available in the database
     *
     * @return List of all the orders
     */
    @GetMapping("all")
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }

    /**
     * Get information on all the orders assigned to the receipt of given id
     *
     * @param receipt id of the receipt
     * @return List of information on all orders included in the receipt
     */
    @GetMapping("/receipt/{receipt}")
    public List<OrderInfoWaiter> findOrdersByReceipt(@PathVariable Long receipt) {
        return repository.findOrdersByReceiptId(receipt);
    }

    /**
     * Get information on all the orders with given status
     * When status is 1, then this method returns placed orders, not assigned to any cooks
     *
     * @param status status of orders to retrieve from database
     * @return List of information on all the orders with given status
     */
    @GetMapping("/desktop/placed/{status}")
    public List<OrderInfoCook> findOrdersByStatusAndEmployeeIsNull(@PathVariable int status) {
        return repository.findByStatusAndEmployeeIsNull(status);
    }

    /**
     * Get information on all the orders with given status
     * When status is 1, then this method returns orders in progress, assigned to cook, but not finished
     *
     * @param status status of orders to retrieve from database
     * @return List of information on all the orders with given status
     */
    @GetMapping("/desktop/progress/{status}")
    public List<OrderInfoCook> findOrdersByStatusAndEmployeeIsNotNull(@PathVariable int status) {
        return repository.findByStatusAndEmployeeIsNotNull(status);
    }

    /**
     * Method to assign an employee to the order
     *
     * @param orderId    id of order to which employee must be assigned
     * @param employeeId id of employee to assign
     * @return Updated order saved in the database
     */
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

    /**
     * Advance status of the order (do not decrease status)
     *
     * @param orderId id of the order to update
     * @param status  new status
     * @return Updated value of the order
     */
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

    /**
     * Save new order in the database
     *
     * @param order value of the new order to save
     * @return Saved order (new id has been generated)
     */
    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return repository.save(order);
    }

    /**
     * Delete order of given id from the database
     *
     * @param id id of the order to delete from the database
     */
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
