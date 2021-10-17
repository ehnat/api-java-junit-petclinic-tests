package com.petclinic.tests;

import com.petclinic.services.VetService;
import com.petclinic.tests.tags.RegressionTest;
import com.petclinic.tests.tags.SmokeTest;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Vets:")
public class VetsTest {

    private static final int INITIAL_VETS_AMOUNT = 6;

    @RegressionTest
    @SmokeTest
    @DisplayName("should return all vets")
    void shouldReturnAllVets() {
        //when
        var allVets = VetService.getAllVets();

        //then
        assertAll("vets",
                () -> assertTrue(allVets.size() > 0, () -> "vets amount is greater than 0"),
                () -> assertEquals(INITIAL_VETS_AMOUNT, allVets.size(), () -> "vets amount = 6 (initial value)")
        );
    }
}
