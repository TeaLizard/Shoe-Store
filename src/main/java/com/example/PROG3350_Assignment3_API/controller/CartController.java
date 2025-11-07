package com.example.PROG3350_Assignment3_API.controller;

import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.service.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final UnitOfWork unitOfWork;
    private final int ID = 1; // There is only one cart because there is only one user; no login or user data
    @Autowired
    public CartController(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    @GetMapping
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok(unitOfWork.getCartService().get(ID));
    }

    @PutMapping("{productId}")
    public ResponseEntity<?> addToCart(@PathVariable("productId") int productId) { // ? for String response on bad request
        var cart = unitOfWork.getCartService().get(ID);
        var shoe = unitOfWork.getShoeService().getById(productId);
        if (!shoe.getIsActive()) {
            return ResponseEntity.badRequest().body("Shoe is not active");
        }
        unitOfWork.getCartService().addToCart(ID, productId);
        return ResponseEntity.ok(unitOfWork.getShoeService().getById(productId));
    }

    @DeleteMapping()
    public ResponseEntity<?> emptyCart(@PathVariable("productId") int productId) { // ? for no type needed
        unitOfWork.getCartService().emptyCart(ID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> removeItem(@PathVariable("productId") int productId) {
        unitOfWork.getCartService().removeItem(ID, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("destroy/{cartId}")
    public ResponseEntity<?> destroyCart(@PathVariable("cartId") int cartId) {
        unitOfWork.getCartService().destroyCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
