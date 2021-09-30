package com.petclinic.tests;

import com.petclinic.data.databuilders.OwnerMakers;
import com.petclinic.data.databuilders.PetMakers;
import com.petclinic.data.databuilders.VisitMakers;
import com.petclinic.data.dto.Owner;
import com.petclinic.data.dto.Pet;
import com.petclinic.data.dto.Visit;
import com.petclinic.services.OwnerService;

import java.util.List;


import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.natpryce.makeiteasy.MakeItEasy.withNull;
import static com.petclinic.data.databuilders.OwnerMakers.address;
import static com.petclinic.data.databuilders.OwnerMakers.lastName;
import static com.petclinic.data.databuilders.PetMakers.owner;

public class BuildDataTest {

    public static void main(String[] args) {
        System.out.println(getOwners());
        System.out.println(getPets());
        System.out.println(getVisits());
    }

    private static List<Owner> getOwners() {
        var owner1 = make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR)
        );

        var owner2 = make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR, with(OwnerMakers.id, 111))
        );

        var owner3 = make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR, with(address, "adres3"))
                        .but(with(lastName, "owner3"))

        );

        var owner4 = make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR, withNull(OwnerMakers.id))
        );

        return List.of(owner1, owner2, owner3, owner4);
    }

    private static List<Visit> getVisits() {
        return List.of(
                make(
                        a(VisitMakers.DEFAULT_VISIT_INSTANTIATOR)
                ),
                make(
                        a(VisitMakers.DEFAULT_VISIT_INSTANTIATOR, with(VisitMakers.id, 15))
                )
        );
    }

    private static List<Pet> getPets() {
        return List.of(
                make(
                        a(PetMakers.DEFAULT_PET_INSTANTIATOR)
                ),
                make(
                        a(PetMakers.DEFAULT_PET_INSTANTIATOR, with(owner, OwnerService.getOwner(1)))
                )
        );
    }
}
