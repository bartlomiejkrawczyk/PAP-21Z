package com.example.restaurant.entities;

import java.io.Serializable;
import java.util.List;

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

    public int getTotal() {
        int total = 0;

        if (orders != null) {
            for (Order o : orders)
                total += o.getDish().getPrice();
        }

        return total;
    }

    public String formatTotal() {
        int total = getTotal();
        int bucks = total / 100;
        int pennies = total % 100;
        String sPennies = String.valueOf(pennies);
        if (pennies < 10)
            sPennies = "0" + sPennies;

        return bucks + "," + sPennies + " PLN";
    }

    public boolean canClose() {
        boolean close = true;
        if (orders != null) {
            for (Order o : orders) {
                if (o.getStatus() != 3) {
                    close = false;
                    break;
                }
            }
        }
        return close;
    }

    public boolean canDelete() {
        boolean close = true;
        if (orders != null) {
            for (Order o : orders) {
                if (o.getStatus() == 3) {
                    close = false;
                    break;
                }
            }
        }
        return close;
    }
}
