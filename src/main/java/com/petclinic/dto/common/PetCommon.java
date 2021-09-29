package com.petclinic.dto.common;

import com.petclinic.dto.PetType;
import com.petclinic.dto.VisitResponse;

import java.util.List;

public record PetCommon(int id, String name, String birthDate,
                        PetType type, List<VisitResponse> visits) {
}
