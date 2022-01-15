package com.example.restaurant.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Entity that stores information about receipt
 * <p>
 * Receipt can be in two states (indicated by payment):
 * - payment == 0 - the receipt is open - waiter can add more orders to the receipt
 * - payment != 0 - the receipt is closed - every order included in order must have status 3 - already served
 * <p>
 * Waiter can be assigned to receipt
 * - employee will add orders for dishes
 * and will handle every prepared order in this receipt
 * <p>
 * Every receipt is assigned to one table
 *
 * @see Order
 * @see Employee
 * @see Table
 */
public class Receipt implements Serializable {

    private Long id;

    private Integer payment;

    private Employee employee;

    private Table table;

    private List<Order> orders;

    public Receipt() {
    }

    public Receipt(Long id, Integer payment, Employee employee, Table table, List<Order> orders) {
        this.id = id;
        this.payment = payment;
        this.employee = employee;
        this.table = table;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Sum all the prices of ordered dishes
     *
     * @return sum of the prices of the ordered dishes
     */
    public int getTotal() {
        int total = 0;

        if (orders != null) {
            for (Order o : orders)
                if (o != null && o.getDish() != null && o.getDish().getPrice() != null)
                    total += o.getDish().getPrice();
        }

        return total;
    }

    /**
     * Format total price - result of getTotal
     *
     * @return String with formatted price
     */
    public String formatTotal() {
        int total = getTotal();
        int bucks = total / 100;
        int pennies = total % 100;
        String sPennies = String.valueOf(pennies);
        if (pennies < 10)
            sPennies = "0" + sPennies;

        return bucks + "," + sPennies + " PLN";
    }

    /**
     * Check whether there are any orders
     * that haven't been brought to the table
     *
     * @return True when there are no orders with status different then 3, else false
     */
    public boolean canClose() {
        boolean close = true;
        if (orders != null) {
            for (Order o : orders) {
                if (o != null && o.getStatus() != 3) {
                    close = false;
                    break;
                }
            }
        }
        return close;
    }

    /**
     * Check whether there are any orders
     * that have been brought to the table
     *
     * @return True when there are no orders with status 3, else false
     */
    public boolean canDelete() {
        boolean close = true;
        if (orders != null) {
            for (Order o : orders) {
                if (o != null && o.getStatus() == 3) {
                    close = false;
                    break;
                }
            }
        }
        return close;
    }
}
