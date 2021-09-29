package com.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.petclinic.dto.common.VisitCommon;

public record VisitResponse(VisitCommon visitCommon, @JsonProperty("pet") int petId) {
}
