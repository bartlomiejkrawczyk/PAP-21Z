package com.example.api.projections;


import java.util.Objects;

public class MockEmployeeNamesOnly {

    private final Long id;
    private final String name;

    public MockEmployeeNamesOnly(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockEmployeeNamesOnly that = (MockEmployeeNamesOnly) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }
}
