package com.example.PROG3350_Assignment3_API.model.dto;

import java.util.List;

public class CartDTO {
    private Integer id;
    private List<ShoeDTO> shoes;

    public CartDTO() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public List<ShoeDTO> getShoes() {
        return shoes;
    }
    public void setShoes(List<ShoeDTO> shoes) {
        this.shoes = shoes;
    }
}
