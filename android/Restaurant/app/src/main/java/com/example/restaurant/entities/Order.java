package com.example.restaurant.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Order is an entity that connects two other entities:
 * - Receipt
 * - Dish
 * <p>
 * It holds information about what dish was ordered with which receipt
 * <p>
 * Cooks can get assigned to orders
 * Order can have multiple specialRequests
 * <p>
 * Every order can be in four states (indicated by status and employee):
 * status: 1, employee: null - order requested, but preparing hasn't started
 * status: 1, employee: assigned - order is being prepared
 * status: 2, employee: assigned - order is ready to be served
 * status: 3, employee: assigned - order is served
 *
 * @see Receipt
 * @see Dish
 * @see Employee
 * @see SpecialRequest
 */
public class Order implements Serializable {

    private Long id;

    private Long date;

    private Dish dish;

    private Long receiptId;

    private List<SpecialRequest> requests;

    private Integer status;


    public Order() {
    }

    public Order(Long id, Long date, Dish dish, Long receiptId, List<SpecialRequest> requests, Integer status) {
        this.id = id;
        this.date = date;
        this.dish = dish;
        this.receiptId = receiptId;
        this.requests = requests;
        this.status = status;
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

    /**
     * Format price of the dish
     *
     * @return String with formatted price
     */
    public String formatPrice() {
        if (dish != null && dish.getPrice() != null) {
            int price = dish.getPrice();
            int bucks = price / 100;
            int pennies = price % 100;
            String sPennies = String.valueOf(pennies);
            if (pennies < 10)
                sPennies = "0" + sPennies;

            return bucks + "," + sPennies + " PLN";
        }
        return "0,00 PLN";
    }

}
