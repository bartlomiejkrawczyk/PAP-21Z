package com.example.api.projections;

import java.time.LocalDate;
import java.util.List;

public interface OrderInfoCook {
    Long getId();

    LocalDate getDate();

    Integer getStatus();

    DishInfo getDish();

    EmployeeInfo getEmployee();

    List<SpecialRequestInfo> getRequests();

    interface DishInfo {
        Long getId();

        String getName();

        String getImagePath();
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
