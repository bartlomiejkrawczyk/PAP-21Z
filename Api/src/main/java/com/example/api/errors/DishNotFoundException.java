package com.example.api.errors;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException(Long id) {
        super("Could not find dish: " + id);
    }
}
