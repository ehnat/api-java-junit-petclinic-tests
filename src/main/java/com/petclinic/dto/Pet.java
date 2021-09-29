package com.petclinic.dto;

import com.petclinic.dto.common.PetCommon;

public record Pet(PetCommon petCommon, Owner owner) {
}
