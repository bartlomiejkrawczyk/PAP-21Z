package com.example.api.projections;

public interface ReceiptInfo {
    Long getId();

    Long getPayment();

    TableInfo getTable();

    interface TableInfo {
        Long getId();

        String getName();
    }
}
