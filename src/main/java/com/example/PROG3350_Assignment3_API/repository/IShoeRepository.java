package com.example.PROG3350_Assignment3_API.repository;

import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoeRepository extends JpaRepository<Shoe, Integer> {
}
