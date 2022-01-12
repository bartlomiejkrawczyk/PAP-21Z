package com.example.restaurant.entities;

import com.example.restaurant.errors.InvalidData;

import java.io.Serializable;

public class SpecialRequest implements Serializable {
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


    /**
     * Function to verify whether data given by user are valid
     *
     * @throws InvalidData empty request or order is null
     */
    public void validateData() throws InvalidData {
        if (request == null || request.length() == 0)
            throw new InvalidData("Empty Request");

        if (orderId == null)
            throw new InvalidData("No order Id is set");
    }
}
