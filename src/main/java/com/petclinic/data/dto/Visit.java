package com.petclinic.data.dto;

public record Visit(int id, String date, String description, Pet pet) {
    // date example: yyyy/MM/dd
}
