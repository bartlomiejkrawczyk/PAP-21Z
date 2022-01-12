package com.example.restaurant.entities;

import static com.example.restaurant.utils.SerializeUtils.deserialize;
import static com.example.restaurant.utils.SerializeUtils.serialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TableTest {


    @Test
    public void tableEmptyConstructor() {
        Table table = new Table();
        assertNull(table.getId());
        assertNull(table.getName());
    }

    @Test
    public void tableConstructor() {
        Table table = new Table(1L, "test");
        assertEquals(Long.valueOf(1L), table.getId());
        assertEquals("test", table.getName());
    }

    @Test
    public void tableSetters() {
        Table table = new Table();
        table.setId(1L);
        table.setName("test");
        assertEquals(Long.valueOf(1L), table.getId());
        assertEquals("test", table.getName());
        table.setId(null);
        table.setName(null);
        assertNull(table.getId());
        assertNull(table.getName());
    }

    @Test
    public void tableToStringSimple() {
        Table table = new Table(1L, "test");
        assertEquals("1 - test", table.toString());
    }

    @Test
    public void tableToStringNullId() {
        Table table = new Table(null, "test");
        assertEquals("test", table.toString());
    }

    @Test
    public void tableToStringNullName() {
        Table table = new Table(1L, null);
        assertEquals("Table", table.toString());
    }

    @Test
    public void tableToStringNullIdAndNullName() {
        Table table = new Table(null, null);
        assertEquals("Table", table.toString());
    }

    @Test
    public void tableSerialize() {
        List<Table> tables = Arrays.asList(
                new Table(1L, "test"),
                new Table(1L, null),
                new Table(null, "test"),
                new Table(null, null)
        );
        tables.forEach(table -> {
            try {
                Table output = deserialize(serialize(table), Table.class);
                assertEquals(table.getId(), output.getId());
                assertEquals(table.getName(), output.getName());
            } catch (IOException | ClassNotFoundException e) {
                fail();
            }
        });
    }


}
