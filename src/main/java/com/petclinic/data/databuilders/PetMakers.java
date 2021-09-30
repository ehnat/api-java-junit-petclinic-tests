package com.petclinic.data.databuilders;

import com.github.javafaker.Faker;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.petclinic.data.databuilders.util.Utils;
import com.petclinic.data.dto.Owner;
import com.petclinic.data.dto.Pet;
import com.petclinic.data.dto.PetType;
import com.petclinic.data.dto.VisitResponse;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;

import java.util.List;

import static com.natpryce.makeiteasy.Property.newProperty;

public class PetMakers {

    private static final Faker FAKER = new Faker();

    public static final Property<Pet, Integer> id = newProperty();
    public static final Property<Pet, String> name = newProperty();
    public static final Property<Pet, String> birthDate = newProperty();
    public static final Property<Pet, PetType> type = newProperty();
    public static final Property<Pet, Owner> owner = newProperty();
    public static final Property<Pet, List<VisitResponse>> visits = newProperty();

    public static final Instantiator<Pet> DEFAULT_PET_INSTANTIATOR = lookup -> new Pet(
            lookup.valueOf(id, 1),
            lookup.valueOf(name, FAKER.name().firstName()),
            lookup.valueOf(birthDate, Utils.getTodayDate()),
            lookup.valueOf(type, PetService.getPetType(2)),
            lookup.valueOf(owner, OwnerService.getOwner(1)),
            lookup.valueOf(visits, List.of())
    );
}
