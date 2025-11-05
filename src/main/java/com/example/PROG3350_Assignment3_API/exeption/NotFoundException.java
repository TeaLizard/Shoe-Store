package com.example.PROG3350_Assignment3_API.exeption;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String itemType, int itemId) {
        super(itemType + " with id " + itemId + " not found");
    }
}
