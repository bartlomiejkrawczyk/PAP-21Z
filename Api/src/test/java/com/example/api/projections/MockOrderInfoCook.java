package com.example.api.projections;

import com.example.api.entities.SpecialRequest;

import java.util.List;
import java.util.Objects;

public class MockOrderInfoCook {

    private final Long id;
    private final Long date;
    private final Integer status;
    private final MockDishInfo dish;
    private final MockEmployeeInfo employee;
    private final List<SpecialRequest> requests;

    public MockOrderInfoCook(Long id, Long date, Integer status, MockDishInfo dish, MockEmployeeInfo employee, List<SpecialRequest> requests) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.dish = dish;
        this.employee = employee;
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockOrderInfoCook that = (MockOrderInfoCook) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(dish, that.dish)) return false;
        if (!Objects.equals(employee, that.employee)) return false;
        return Objects.equals(requests, that.requests);
    }

    public static class MockDishInfo {
        private final Long id;

        public MockDishInfo(Long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MockDishInfo that = (MockDishInfo) o;

            return Objects.equals(id, that.id);
        }
    }

    public static class MockEmployeeInfo {
        private final Long id;

        public MockEmployeeInfo(Long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MockEmployeeInfo that = (MockEmployeeInfo) o;

            return Objects.equals(id, that.id);
        }
    }

}
