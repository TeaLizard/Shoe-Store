package com.example.PROG3350_Assignment3_API.controller;

import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.service.UnitOfWork;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ShoeController {
    private final UnitOfWork unitOfWork;
    @Autowired
    public ShoeController(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    @GetMapping
    public ResponseEntity<List<Shoe>> getAllShoes() {
        var shoes = unitOfWork.getShoeService().getAll();
        if (shoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shoes);
    }

    @GetMapping("{productId}")
    public ResponseEntity<Shoe> getShoe(@PathVariable("productId") int productId) {
        return ResponseEntity.ok(unitOfWork.getShoeService().getById(productId));
    }

    @PostMapping
    public ResponseEntity<Shoe> createShoe(@RequestBody @Valid Shoe shoe) {
        shoe.setId(null);
        return ResponseEntity.ok(unitOfWork.getShoeService().add(shoe));
    }

    @PutMapping("{productId}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable("productId") int productId, @RequestBody @Valid Shoe shoe) {
        shoe.setId(productId);
        unitOfWork.getShoeService().update(shoe);
        return ResponseEntity.ok(unitOfWork.getShoeService().getById(shoe.getId()));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteShoe(@PathVariable("productId") int productId) { // ? for no type needed
        unitOfWork.getShoeService().delete(productId);
        return ResponseEntity.noContent().build();
    }
}
