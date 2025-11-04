package com.example.PROG3350_Assignment3_API.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String sku;

    @NotBlank
    @Column(nullable = false, name = "is-active")
    private Boolean isActive;

    @NotBlank
    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String image;

    public Shoe() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}








































