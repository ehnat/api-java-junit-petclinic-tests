package com.petclinic.dto;

import com.petclinic.dto.common.VisitCommon;

public record Visit(VisitCommon visitCommon, Pet pet) {
}
