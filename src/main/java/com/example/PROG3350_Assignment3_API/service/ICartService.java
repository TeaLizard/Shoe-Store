package com.example.PROG3350_Assignment3_API.service;

import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICartService {
    Cart get(Integer id);
    void addToCart(Integer id, Integer itemId);
    void emptyCart(Integer id);
    void removeItem(Integer id, Integer itemId);
}
