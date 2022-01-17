package com.example.desktop.entities;

/**
 * Entity that stores information about customer's special request
 * about the dish he ordered
 *
 * @see Order
 */
public class SpecialRequest {
    private Long id;

    private String request;

    private Long orderId;

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
