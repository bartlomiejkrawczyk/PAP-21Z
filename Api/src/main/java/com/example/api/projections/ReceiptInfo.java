package com.example.api.projections;


/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.Receipt
 */
public interface ReceiptInfo {
    Long getId();

    Integer getPayment();

    TableInfo getTable();

    interface TableInfo {
        Long getId();

        String getName();
    }
}
