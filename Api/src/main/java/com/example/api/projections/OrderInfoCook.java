package com.example.api.projections;

import java.util.List;


/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.Order
 */
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
