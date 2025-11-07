package com.example.PROG3350_Assignment3_API.model.mapper;

import com.example.PROG3350_Assignment3_API.model.dto.CartDTO;
import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartMapper {
    private final ICartRepository cartRepository;
    private final ShoeMapper shoeMapper;
    @Autowired
    public CartMapper(ICartRepository cartRepository, ShoeMapper shoeMapper) {
        this.cartRepository = cartRepository;
        this.shoeMapper = shoeMapper;
    }

    public CartDTO toDTO(Cart cart) {
        var cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        var shoesDTO = cart.getShoes().stream().map(shoeMapper::toDTO).collect(Collectors.toList());
        cartDTO.setShoes(shoesDTO);
        return cartDTO;
    }

    public Cart toEntity(CartDTO cartDTO) {
        var cart = new Cart();
        cart.setId(cartDTO.getId());
        var shoes = cartDTO.getShoes().stream().map(shoeMapper::toEntity).collect(Collectors.toList());
        cart.setShoes(shoes);
        return cart;
    }
}
