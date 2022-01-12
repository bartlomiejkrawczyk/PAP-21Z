package com.example.api.projections;

import java.util.List;

public interface OrderInfoCook {
    Long getId();

    Long getDate();

    Integer getStatus();

    DishInfo getDish();

    EmployeeInfo getEmployee();

    List<SpecialRequestInfo> getRequests();

    interface DishInfo {
        Long getId();
    }

    interface EmployeeInfo {
        Long getId();
    }

    interface SpecialRequestInfo {
        Long getId();

        Long getOrderId();

        String getRequest();
    }
}
