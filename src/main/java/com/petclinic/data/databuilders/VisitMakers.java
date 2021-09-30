package com.petclinic.data.databuilders;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.petclinic.data.databuilders.util.Utils;
import com.petclinic.data.dto.Pet;
import com.petclinic.data.dto.Visit;
import com.petclinic.services.PetService;

import static com.natpryce.makeiteasy.Property.newProperty;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class VisitMakers {

    public static final Property<Visit, Integer> id = newProperty();
    public static final Property<Visit, String> date = newProperty();
    public static final Property<Visit, String> description = newProperty();
    public static final Property<Visit, Pet> pet = newProperty();

    public static final Instantiator<Visit> DEFAULT_VISIT_INSTANTIATOR = lookup -> new Visit(
            lookup.valueOf(id, 0),
            lookup.valueOf(date, Utils.getTodayDate()),
            lookup.valueOf(description, randomAlphabetic(10)),
            lookup.valueOf(pet, PetService.getPet(7))
    );
}
