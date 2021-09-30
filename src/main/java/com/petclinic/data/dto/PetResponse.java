package com.petclinic.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PetResponse(Integer id, String name, String birthDate,
                          PetType type, @JsonProperty("owner") int ownerId, List<VisitResponse> visits) {
}
