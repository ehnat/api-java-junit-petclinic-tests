package com.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.petclinic.dto.common.PetCommon;

public record PetResponse(PetCommon petCommon, @JsonProperty("owner") int ownerId) {
}
