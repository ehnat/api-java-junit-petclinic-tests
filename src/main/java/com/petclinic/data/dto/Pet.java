package com.petclinic.data.dto;

import java.util.List;

public record Pet(int id, String name, String birthDate,
                  PetType type, Owner owner, List<VisitResponse> visits) {
}
