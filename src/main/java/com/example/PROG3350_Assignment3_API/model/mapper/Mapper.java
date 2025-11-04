package com.example.PROG3350_Assignment3_API.model.mapper;

import com.example.PROG3350_Assignment3_API.model.dto.CartDTO;
import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.model.dto.ShoeDTO;
import com.example.PROG3350_Assignment3_API.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private CartMapper cartMapper;
    private ShoeMapper shoeMapper;

    @Autowired
    public Mapper(CartMapper cartMapper, ShoeMapper shoeMapper) {
        this.cartMapper = cartMapper;
        this.shoeMapper = shoeMapper;
    }

    public CartMapper getCartMapper() {
        return cartMapper;
    }

    public ShoeMapper getShoeMapper() {
        return shoeMapper;
    }
}
