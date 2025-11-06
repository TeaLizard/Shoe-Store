package com.example.PROG3350_Assignment3_API.controller;

import com.example.PROG3350_Assignment3_API.model.dto.ShoeDTO;
import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.model.mapper.ShoeMapper;
import com.example.PROG3350_Assignment3_API.service.UnitOfWork;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ShoeController {
    private final UnitOfWork unitOfWork;
    public ShoeController(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    @GetMapping
    public ResponseEntity<List<ShoeDTO>> getAllShoes() {
        var shoes = unitOfWork.getShoeService().getAll();
        if (shoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        var mapper = unitOfWork.getMapper().getShoeMapper();
        var shoeDTOs = shoes.stream().map(mapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(shoeDTOs);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ShoeDTO> getShoe(@PathVariable("productId") int productId) {
        return ResponseEntity.ok(unitOfWork.getMapper().getShoeMapper().toDTO(unitOfWork.getShoeService().getById(productId)));
    }

    @PostMapping
    public ResponseEntity<ShoeDTO> createShoe(@RequestBody @Valid Shoe shoe) {
        shoe.setId(null);
        unitOfWork.getShoeService().add(shoe);
        return ResponseEntity.ok(unitOfWork.getMapper().getShoeMapper().toDTO(unitOfWork.getShoeService().getById(shoe.getId())));
    }

    @PutMapping("{productId}")
    public ResponseEntity<ShoeDTO> updateShoe(@PathVariable("productId") int productId, @RequestBody @Valid Shoe shoe) {
        shoe.setId(productId);
        unitOfWork.getShoeService().update(shoe);
        return ResponseEntity.ok(unitOfWork.getMapper().getShoeMapper().toDTO(unitOfWork.getShoeService().getById(productId)));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Boolean> deleteShoe(@PathVariable("productId") int productId) {
        unitOfWork.getShoeService().delete(productId);
        return ResponseEntity.noContent().build();
    }
}
