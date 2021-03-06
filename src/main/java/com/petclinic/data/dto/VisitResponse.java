package com.petclinic.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VisitResponse(int id, String date, String description, @JsonProperty("pet") int petId) {
// date example: yyyy/MM/dd
}
