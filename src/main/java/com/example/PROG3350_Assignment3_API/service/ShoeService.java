package com.example.PROG3350_Assignment3_API.service;

import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.repository.IShoeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService implements IShoeService {
    private final IShoeRepository repository;
    public ShoeService(IShoeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Shoe> getAll() {
        return repository.findAll();
    }

    @Override
    public Shoe getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoe with id " + id + " not found"));
    }

    @Override
    public void add(Shoe shoe) {
        repository.save(shoe);
    }

    @Override
    public void update(Shoe shoe) {
        var old = repository.findById(shoe.getId())
                .orElseThrow(() -> new RuntimeException("Shoe with id " + shoe.getId() + " not found"));

        old.setName(shoe.getName());
        old.setDescription(shoe.getDescription());
        old.setPrice(shoe.getPrice());
        old.setSku(shoe.getSku());
        old.setIsActive(shoe.getIsActive());
        old.setImage(shoe.getImage());
        repository.save(old);
    }

    @Override
    public void delete(int id) {
        var shoe = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoe with id " + id + " not found"));

        repository.delete(shoe);
    }
}
