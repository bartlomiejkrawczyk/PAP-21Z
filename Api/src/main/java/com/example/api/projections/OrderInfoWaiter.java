package com.example.api.projections;

import java.util.List;


/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.Order
 */
public interface OrderInfoWaiter {
    Long getId();

    Long getDate();

    DishInfo getDish();

    Long getReceiptId();

    List<SpecialRequestInfo> getRequests();

    Integer getStatus();

    interface DishInfo {
        Long getId();
    }

    interface SpecialRequestInfo {
        Long getId();

        Long getOrderId();

        String getRequest();
    }
}
