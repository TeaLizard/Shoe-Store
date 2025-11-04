package com.example.PROG3350_Assignment3_API.repository;

import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer> {
}
