package com.example.PROG3350_Assignment3_API.service;

import org.springframework.stereotype.Component;

@Component
public class UnitOfWork {
    private final IShoeService shoeService;
    private final ICartService cartService;
    public UnitOfWork(IShoeService shoeService, ICartService cartService) {
        this.shoeService = shoeService;
        this.cartService = cartService;
    }

    public IShoeService getShoeService() {
        return shoeService;
    }
    public ICartService getCartService() {
        return cartService;
    }
}
