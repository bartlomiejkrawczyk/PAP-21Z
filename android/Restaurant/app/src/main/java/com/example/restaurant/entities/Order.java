package com.example.restaurant.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;

    private Dish dish;

    private Long receiptId;

    private List<SpecialRequest> requests;

    private Integer status;

    private Employee employee;

    public Order() {
    }

    public Order(Long id, LocalDate date, Dish dish, Long receiptId, List<SpecialRequest> requests, Integer status, Employee employee) {
        this.id = id;
        this.dish = dish;
        this.receiptId = receiptId;
        this.requests = requests;
        this.status = status;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public List<SpecialRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<SpecialRequest> requests) {
        this.requests = requests;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
