package com.example.PROG3350_Assignment3_API.service;

import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IShoeService {
    List<Shoe> getAll();
    Shoe getById(int id);
    Shoe add(Shoe shoe);
    void update(Shoe shoe);
    void delete(int id);
}
