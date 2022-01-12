package com.example.api.projections;

import java.util.Objects;

public class MockProductInfo {
    private final Long id;
    private final String name;
    private final String unit;

    public MockProductInfo(Long id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockProductInfo that = (MockProductInfo) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(unit, that.unit);
    }

}
