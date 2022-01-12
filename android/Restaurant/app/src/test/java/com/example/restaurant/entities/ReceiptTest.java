package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptTest {
    @Test
    public void receiptEmptyConstructor() {
        Receipt receipt = new Receipt();
        assertNull(receipt.getId());
        assertNull(receipt.getPayment());
        assertNull(receipt.getEmployee());
        assertNull(receipt.getTable());
        assertNull(receipt.getOrders());
    }

    @Test
    public void receiptConstructor() {
        Employee employee = new Employee(1L, "Jan Kowalski");
        Table table = new Table(1L, "table");
        Dish dish = new Dish(1L, "Tomato", null, 1200, 1L);
        List<SpecialRequest> requests = new ArrayList<>();
        List<Order> orders = Arrays.asList(
                new Order(1L, null, dish, 1L, requests, 1),
                new Order(2L, null, dish, 1L, requests, 1));

        Receipt receipt = new Receipt(1L, 0, employee, table, orders);

        assertEquals(Long.valueOf(1L), receipt.getId());
        assertEquals(Integer.valueOf(0), receipt.getPayment());
        assertEquals(employee, receipt.getEmployee());
        assertEquals(table, receipt.getTable());
        assertEquals(orders, receipt.getOrders());
    }

    @Test
    public void receiptSetters() {
        Receipt receipt = new Receipt();

        Employee employee = new Employee(1L, "Jan Kowalski");
        Table table = new Table(1L, "table");
        Dish dish = new Dish(1L, "Tomato", null, 1200, 1L);
        List<SpecialRequest> requests = new ArrayList<>();
        List<Order> orders = Arrays.asList(
                new Order(1L, null, dish, 1L, requests, 1),
                new Order(2L, null, dish, 1L, requests, 1));

        receipt.setId(1L);
        receipt.setPayment(0);
        receipt.setEmployee(employee);
        receipt.setTable(table);
        receipt.setOrders(orders);

        assertEquals(Long.valueOf(1L), receipt.getId());
        assertEquals(Integer.valueOf(0), receipt.getPayment());
        assertEquals(employee, receipt.getEmployee());
        assertEquals(table, receipt.getTable());
        assertEquals(orders, receipt.getOrders());
    }

    @Test
    public void receiptGetTotal() {
        Dish dish1 = new Dish(1L, "Tomato", null, 1234, 1L);
        Dish dish2 = new Dish(1L, "Chicken", null, 4321, 1L);
        Dish dish3 = new Dish(1L, "Chicken", null, null, 1L);
        Order order1 = new Order(1L, null, dish1, 1L, null, 1);
        Order order2 = new Order(2L, null, dish2, 1L, null, 1);
        Order order3 = new Order(3L, null, dish3, 1L, null, 1);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(null);

        Receipt receipt = new Receipt();
        receipt.setOrders(orders);

        assertEquals(5555, receipt.getTotal());

        receipt.getOrders().remove(order1);

        assertEquals(4321, receipt.getTotal());

        receipt.getOrders().remove(order2);

        assertEquals(0, receipt.getTotal());

        receipt.getOrders().remove(order3);

        assertEquals(0, receipt.getTotal());

        receipt.getOrders().remove(0);

        assertEquals(0, receipt.getTotal());
    }

    @Test
    public void receiptFormatTotal() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        Order order = new Order(1L, null, dish, 1L, null, 1);

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        Receipt receipt = new Receipt();
        receipt.setOrders(orders);

        assertEquals("12,34 PLN", receipt.formatTotal());

        dish.setPrice(123401);
        assertEquals("1234,01 PLN", receipt.formatTotal());

        receipt.getOrders().remove(order);
        assertEquals("0,00 PLN", receipt.formatTotal());

        receipt.getOrders().add(null);
        assertEquals("0,00 PLN", receipt.formatTotal());
    }

    @Test
    public void receiptCanClose() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        Order order1 = new Order(1L, null, dish, 1L, null, 1);
        Order order2 = new Order(2L, null, dish, 1L, null, 2);
        Order order3 = new Order(3L, null, dish, 1L, null, 3);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(null);

        Receipt receipt = new Receipt();
        receipt.setOrders(orders);

        assertFalse(receipt.canClose());

        receipt.getOrders().remove(order1);
        assertFalse(receipt.canClose());

        receipt.getOrders().remove(order2);
        assertTrue(receipt.canClose());

        receipt.getOrders().remove(order3);
        assertTrue(receipt.canClose());

        receipt.getOrders().remove(0);
        assertTrue(receipt.canClose());
    }

    @Test
    public void receiptCanDelete() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        Order order1 = new Order(1L, null, dish, 1L, null, 1);
        Order order2 = new Order(2L, null, dish, 1L, null, 2);
        Order order3 = new Order(3L, null, dish, 1L, null, 3);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(null);

        Receipt receipt = new Receipt();
        receipt.setOrders(orders);

        assertFalse(receipt.canDelete());

        receipt.getOrders().remove(order1);
        assertFalse(receipt.canDelete());

        receipt.getOrders().remove(order3);
        assertTrue(receipt.canDelete());

        receipt.getOrders().remove(order2);
        assertTrue(receipt.canDelete());

        receipt.getOrders().remove(0);
        assertTrue(receipt.canDelete());
    }

    @Test
    public void receiptSerialize() {
        Employee employee = new Employee(1L, "Jan Kowalski");
        Table table = new Table(1L, "table");
        Dish dish = new Dish(1L, "Tomato", null, 1200, 1L);
        List<Order> orders = Arrays.asList(
                new Order(1L, null, dish, 1L, new ArrayList<>(), 1),
                new Order(2L, null, dish, 1L, new ArrayList<>(), 1));


        List<Receipt> receipts = Arrays.asList(
                new Receipt(1L, 0, employee, table, orders),
                new Receipt(null, 0, employee, table, orders),
                new Receipt(1L, null, employee, table, orders),
                new Receipt(1L, 0, null, table, orders),
                new Receipt(1L, 0, employee, null, orders),
                new Receipt(1L, 0, employee, table, null),
                new Receipt()
        );

        receipts.forEach(receipt -> {
            try {
                Receipt output = deserialize(serialize(receipt), Receipt.class);

                assertEquals(receipt.getId(), output.getId());
                assertEquals(receipt.getPayment(), output.getPayment());
                if (receipt.getEmployee() != null)
                    assertEquals(receipt.getEmployee().toString(), output.getEmployee().toString());
                else
                    assertNull(output.getEmployee());
                if (receipt.getTable() != null)
                    assertEquals(receipt.getTable().toString(), output.getTable().toString());
                else
                    assertNull(output.getTable());
                if (receipt.getOrders() != null) {
                    assertEquals(receipt.getOrders().size(), output.getOrders().size());
                    if (receipt.getOrders().size() > 0 && receipt.getOrders().get(0) != null)
                        assertEquals(receipt.getOrders().get(0).getId(), output.getOrders().get(0).getId());
                } else
                    assertNull(output.getOrders());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }
}
