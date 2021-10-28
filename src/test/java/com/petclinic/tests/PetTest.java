package com.petclinic.tests;

import com.petclinic.data.databuilders.PetMakers;
import com.petclinic.services.PetService;
import com.petclinic.tests.tags.RegressionTest;
import com.petclinic.tests.tags.SmokeTest;
import org.junit.jupiter.api.DisplayName;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Pets:")
public class PetTest {

    private static final int INITIAL_PETS_AMOUNT = 13;

    @SmokeTest
    @DisplayName("should return all pets")
    void shouldReturnAllPets() {
        //when
        var allPets = PetService.getAllPets();

        //then
        assertAll("pets",
                () -> assertTrue(allPets.size() > 0, "pets amount is greater than 0"),
                () -> assertTrue(allPets.size() >= INITIAL_PETS_AMOUNT, "pets amount >= 13 (initial value)")
        );
    }

    @RegressionTest
    @DisplayName("should add a new pet")
    void shouldAddPet() {
        //given
        var INITIAL_PETS_AMOUNT = 13;
        var petRequest = make(
                an(PetMakers.DEFAULT_PET_INSTANTIATOR)
        );

        //when
        var addedPet = PetService.addPet(petRequest);

        //then
        assertAll("added pet:",
                () -> assertTrue(addedPet.id() > INITIAL_PETS_AMOUNT, "id > 13"),
                () -> assertEquals(petRequest.name(), addedPet.name(), "name is correct"),
                () -> assertTrue(PetService.getAllPets().size() >= INITIAL_PETS_AMOUNT + 1, "pets amount >= 14")
        );
    }
}
