package com.example.api.projections;

import java.util.List;

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
