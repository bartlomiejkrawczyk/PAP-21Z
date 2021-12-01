package com.example.restaurant.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableTest {
    @Test
    public void tableToString() {
        Table table = new Table(1L, "test");
        assertEquals("1 - test", table.toString());
    }
}
