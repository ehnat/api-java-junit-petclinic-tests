package com.petclinic.tests.advanced;

import com.petclinic.data.databuilders.OwnerMakers;
import com.petclinic.data.databuilders.PetMakers;
import com.petclinic.data.databuilders.VisitMakers;
import com.petclinic.data.dto.Owner;
import com.petclinic.data.dto.Pet;
import com.petclinic.data.dto.Visit;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;
import com.petclinic.services.VisitService;
import com.petclinic.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.natpryce.makeiteasy.MakeItEasy.withNull;
import static com.petclinic.services.VisitService.getAllVisits;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetVisitTest extends BaseTest {
    private static final int INITIAL_VISITS_AMOUNT = getAllVisits().size();

    @Test
    @DisplayName("new visit should be scheduled for new pet")
    void shouldAddNewVisitForNewPet() {
        //given
        var newOwner = OwnerService.addOwner(getOwnerRequest());
        var newPet = PetService.addPet(getPetRequest(newOwner));

        //when
        var newVisit = VisitService.addVisit(getVisitRequest(newPet));

        //then
        assertAll("new added visit:",
                () -> assertEquals(newVisit.pet().id(), newPet.id(), "has proper petId"),
                () -> assertEquals(newVisit.pet().owner().id(), newOwner.id(), "has proper ownerId"),
                () -> assertEquals(getAllVisits().size(), INITIAL_VISITS_AMOUNT + 1, "increased the number of visits")
        );
    }

    private Owner getOwnerRequest() {
        return make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR,
                        with(OwnerMakers.firstName, "Max"),
                        withNull(OwnerMakers.id))
        );
    }

    private Pet getPetRequest(Owner owner) {
        return make(
                an(PetMakers.DEFAULT_PET_INSTANTIATOR,
                        with(PetMakers.owner, owner))
        );
    }

    private Visit getVisitRequest(Pet pet) {
        return make(
                an(VisitMakers.DEFAULT_VISIT_INSTANTIATOR,
                        with(VisitMakers.pet, pet)
                )
        );
    }
}
