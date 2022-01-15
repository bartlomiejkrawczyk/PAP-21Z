package com.example.restaurant.errors;

/**
 * Custom error called when invalid data has been found in a model
 */
public class InvalidData extends Exception {

    public InvalidData(String message) {
        super(message);
    }
}
