package com.example.api.projections;

import com.example.api.entities.Table;

import java.util.Objects;

public class MockReceiptInfo {

    private final Long id;

    private final Integer payment;

    private final Table table;

    public MockReceiptInfo(Long id, Integer payment, Table table) {
        this.id = id;
        this.payment = payment;
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockReceiptInfo that = (MockReceiptInfo) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(payment, that.payment)) return false;
        return Objects.equals(table, that.table);
    }

}
