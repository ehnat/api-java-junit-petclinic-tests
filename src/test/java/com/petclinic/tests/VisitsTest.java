package com.petclinic.tests;

import com.petclinic.data.databuilders.VisitMakers;
import com.petclinic.data.dto.Visit;
import com.petclinic.services.VisitService;
import com.petclinic.tests.tags.RegressionTest;
import com.petclinic.tests.tags.SmokeParameterizedTest;
import com.petclinic.tests.tags.SmokeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.MethodSource;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Visits:")
public class VisitsTest {

    private static final int INITIAL_VISITS_AMOUNT = 4;

    @SmokeTest
    @RegressionTest
    @DisplayName("should return all visits")
    void shouldReturnAllVets() {
        //when
        var allVisits = VisitService.getAllVisits();

        //then
        assertAll("visits:",
                () -> assertTrue(allVisits.size() > 0, () -> "visits amount is greater than 0"),
                () -> assertTrue(allVisits.size() >= INITIAL_VISITS_AMOUNT, () -> "visits amount >= 4 (initial value)")
        );
    }

    @SmokeParameterizedTest
    @MethodSource("com.petclinic.tests.DataProvider#getVisitDetails")
    @DisplayName("should get a visit")
    void shouldGetVisit(int visitId, String description) {
        //when
        Visit visit = VisitService.getVisit(visitId);

        //then
        assertAll("get visit:",
                () -> assertEquals(visitId, visit.id(), () -> String.format("id is correct: %s", visitId)),
                () -> assertEquals(description, visit.description(), () -> String.format("description is correct: %s", description))
        );
    }

    @RegressionTest
    @DisplayName("should add a new visit")
    void shouldAddVisit() {
        //given
        var visitRequest = make(
                an(VisitMakers.DEFAULT_VISIT_INSTANTIATOR,
                        with(VisitMakers.description, "visit added in test")
                )
        );

        //when
        var addedVisit = VisitService.addVisit(visitRequest);

        //then
        assertAll("added visit:",
                () -> assertTrue(addedVisit.id() > INITIAL_VISITS_AMOUNT, () -> "id > 4"),
                () -> assertEquals(visitRequest.description(), addedVisit.description(), () -> "description = visit added in test"),
                () -> assertTrue(VisitService.getAllVisits().size() >= INITIAL_VISITS_AMOUNT + 1, () -> "visits amount >= 5")
        );
    }
}
