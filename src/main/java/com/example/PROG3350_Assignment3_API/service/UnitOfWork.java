package com.example.PROG3350_Assignment3_API.service;

import com.example.PROG3350_Assignment3_API.model.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UnitOfWork {
    private final IShoeService shoeService;
    private final ICartService cartService;
    private final Mapper mapper;
    public UnitOfWork(IShoeService shoeService, ICartService cartService, Mapper mapper) {
        this.shoeService = shoeService;
        this.cartService = cartService;
        this.mapper = mapper;
    }

    public IShoeService getShoeService() {
        return shoeService;
    }
    public ICartService getCartService() {
        return cartService;
    }
    public Mapper getMapper() {
        return mapper;
    }
}
