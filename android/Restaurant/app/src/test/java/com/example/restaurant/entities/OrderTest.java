package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderTest {

    @Test
    public void orderEmptyConstructor() {
        Order order = new Order();

        assertNull(order.getId());
        assertNull(order.getDate());
        assertNull(order.getDish());
        assertNull(order.getReceiptId());
        assertNull(order.getRequests());
        assertNull(order.getStatus());
    }

    @Test
    public void orderConstructor() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        List<SpecialRequest> requests = new ArrayList<>();
        Order order = new Order(1L, 1640889248850L, dish, 1L, requests, 1);

        assertEquals(Long.valueOf(1L), order.getId());
        assertEquals(Long.valueOf(1640889248850L), order.getDate());
        assertEquals(dish, order.getDish());
        assertEquals(Long.valueOf(1L), order.getReceiptId());
        assertEquals(requests, order.getRequests());
        assertEquals(Integer.valueOf(1), order.getStatus());
    }

    @Test
    public void orderSetters() {
        Order order = new Order();

        order.setId(1L);
        order.setDate(1640889248850L);

        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        order.setDish(dish);

        order.setReceiptId(1L);

        List<SpecialRequest> requests = new ArrayList<>();
        order.setRequests(requests);

        order.setStatus(1);

        assertEquals(Long.valueOf(1L), order.getId());
        assertEquals(Long.valueOf(1640889248850L), order.getDate());
        assertEquals(dish, order.getDish());
        assertEquals(Long.valueOf(1L), order.getReceiptId());
        assertEquals(requests, order.getRequests());
        assertEquals(Integer.valueOf(1), order.getStatus());
    }

    @Test
    public void orderFormatPrice() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        Order order = new Order(1L, null, dish, 1L, null, 1);

        assertEquals("12,34 PLN", order.formatPrice());

        dish.setPrice(123401);
        assertEquals("1234,01 PLN", order.formatPrice());

        dish.setPrice(null);
        assertEquals("0,00 PLN", order.formatPrice());

        order.setDish(null);
        assertEquals("0,00 PLN", order.formatPrice());
    }

    @Test
    public void orderSerialize() {
        Dish dish = new Dish(1L, "Tomato", null, 1234, 1L);
        List<SpecialRequest> requests = Arrays.asList(
                new SpecialRequest(1L, "abc", 1L),
                new SpecialRequest(2L, "bcd", 1L)
        );
        List<Order> orders = Arrays.asList(
                new Order(1L, 1640889248850L, dish, 1L, requests, 1),
                new Order(null, 1640889248850L, dish, 1L, requests, 1),
                new Order(1L, null, dish, 1L, requests, 1),
                new Order(1L, 1640889248850L, null, 1L, requests, 1),
                new Order(1L, 1640889248850L, dish, null, requests, 1),
                new Order(1L, 1640889248850L, dish, 1L, null, 1),
                new Order(1L, 1640889248850L, dish, 1L, requests, null),
                new Order()
        );

        orders.forEach(order -> {
            try {
                Order output = deserialize(serialize(order), Order.class);

                assertEquals(order.getId(), output.getId());
                assertEquals(order.getDate(), output.getDate());
                if (order.getDish() != null)
                    assertEquals(order.getDish().getId(), output.getDish().getId());
                else
                    assertNull(output.getDish());
                assertEquals(order.getReceiptId(), output.getReceiptId());
                if (order.getRequests() != null) {
                    assertEquals(order.getRequests().size(), output.getRequests().size());
                    if (order.getRequests().size() > 0 && order.getRequests().get(0) != null)
                        assertEquals(order.getRequests().get(0).getId(), output.getRequests().get(0).getId());
                } else
                    assertNull(output.getRequests());
                assertEquals(order.getStatus(), output.getStatus());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }
}
