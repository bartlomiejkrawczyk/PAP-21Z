package com.example.restaurant.entities;

public class SpecialRequest {
    private Long id;

    private String request;

    private Long orderId;

    public SpecialRequest() {
    }

    public SpecialRequest(Long id, String request, Long orderId) {
        this.id = id;
        this.request = request;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
