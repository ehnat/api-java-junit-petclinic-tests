package com.petclinic.dto;

import java.util.List;

public record Vet(int id, String firstName, String lastName, List<Specialty> specialties) {
}
