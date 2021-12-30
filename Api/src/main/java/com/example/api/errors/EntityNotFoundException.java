package com.example.api.errors;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Could not find: " + id);
    }
}
