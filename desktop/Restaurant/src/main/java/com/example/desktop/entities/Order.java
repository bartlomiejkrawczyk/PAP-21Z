package com.example.desktop.entities;

import java.util.List;

public class Order {

    private Long id;

    private Long date;

    private Dish dish; // TODO: Note that when downloading from server you only get id of the dish - rest is null

    private Long receiptId;

    private List<SpecialRequest> requests;

    private Integer status;

    private Employee employee; // TODO: Note that when downloading from server you only get id of the employee - rest is null

    public Order() {
    }

    public Order(Long id, Long date, Dish dish, Long receiptId, List<SpecialRequest> requests, Integer status, Employee employee) {
        this.id = id;
        this.date = date;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
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
