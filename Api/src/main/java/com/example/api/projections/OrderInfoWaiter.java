package com.example.api.projections;

import java.time.LocalDate;
import java.util.List;

public interface OrderInfoWaiter {
    Long getId();

    LocalDate getDate();

    Integer getStatus();

    DishInfo getDish();

    List<SpecialRequestInfo> getRequests();

    interface DishInfo {
        Long getId();
    }

    interface SpecialRequestInfo {
        Long getId();

        Long getOrderId();

        String getRequest();
    }
}
