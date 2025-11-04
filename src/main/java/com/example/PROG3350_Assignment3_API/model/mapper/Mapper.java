package com.example.PROG3350_Assignment3_API.model.mapper;

import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.model.dto.ShoeDTO;

public class Mapper {
    public static class ShoeMapper {
        public static ShoeDTO toDTO(Shoe shoe) {
            ShoeDTO shoeDTO = new ShoeDTO();
            shoeDTO.setId(shoe.getId());
            shoeDTO.setName(shoe.getName());
            shoeDTO.setPrice(shoe.getPrice());
            shoeDTO.setDescription(shoe.getDescription());
            shoeDTO.setSku(shoe.getSku());
            shoeDTO.setIsActive(shoe.getIsActive());
            shoeDTO.setImage(shoe.getImage());
            return shoeDTO;
        }

        public static Shoe toEntity(ShoeDTO shoeDTO) {
            Shoe shoe = new Shoe();
            shoe.setId(shoeDTO.getId());
            shoe.setName(shoeDTO.getName());
            shoe.setPrice(shoeDTO.getPrice());
            shoe.setDescription(shoeDTO.getDescription());
            shoe.setSku(shoeDTO.getSku());
            shoe.setIsActive(shoeDTO.getIsActive());
            shoe.setImage(shoeDTO.getImage());
            return shoe;
        }
    }
}
