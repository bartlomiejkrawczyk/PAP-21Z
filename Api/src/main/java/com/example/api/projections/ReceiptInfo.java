package com.example.api.projections;

public interface ReceiptInfo {
    Long getId();

    Integer getPayment();

    TableInfo getTable();

    interface TableInfo {
        Long getId();

        String getName();
    }
}
