package com.petclinic.data.dto;

import java.util.List;

public record Owner(Integer id,
                    String firstName, String lastName,
                    String address, String city, String telephone,
                    List<PetResponse> pets) {
}
