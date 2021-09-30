package com.petclinic.data.dto;

public record Visit(Integer id, String date, String description, Pet pet) {
    // date example: yyyy/MM/dd
}
