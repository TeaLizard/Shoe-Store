package com.example.PROG3350_Assignment3_API.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "cart")
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "cart_items",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "shoe_id")
    )
    private List<Shoe> shoes;

    public Cart() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }
    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }
}
