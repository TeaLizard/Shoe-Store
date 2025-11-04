package com.example.PROG3350_Assignment3_API.model.mapper;

import com.example.PROG3350_Assignment3_API.model.dto.CartDTO;
import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    private final ICartRepository cartRepository;
    @Autowired
    public CartMapper(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDTO toDTO(Cart cart) {
        if(cart == null) return null;
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        return cartDTO;
    }

    public Cart toEntity(CartDTO cartDTO) {
        if (cartDTO == null) return null;
        var cart = cartRepository.findById(cartDTO.getId());
        return cart.orElse(null);
    }
}
