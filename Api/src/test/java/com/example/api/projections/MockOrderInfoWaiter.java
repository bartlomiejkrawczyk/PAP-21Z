package com.example.api.projections;

import com.example.api.entities.SpecialRequest;

import java.util.List;
import java.util.Objects;

public class MockOrderInfoWaiter {

    private final Long id;
    private final Long date;
    private final Long receiptId;
    private final List<SpecialRequest> requests;
    private final Integer status;
    private final MockDishInfo dish;

    public MockOrderInfoWaiter(Long id, Long date, Long receiptId, List<SpecialRequest> requests, Integer status, MockDishInfo dish) {
        this.id = id;
        this.date = date;
        this.receiptId = receiptId;
        this.requests = requests;
        this.status = status;
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockOrderInfoWaiter that = (MockOrderInfoWaiter) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(receiptId, that.receiptId)) return false;
        if (!Objects.equals(requests, that.requests)) return false;
        if (!Objects.equals(status, that.status)) return false;
        return Objects.equals(dish, that.dish);
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
}
