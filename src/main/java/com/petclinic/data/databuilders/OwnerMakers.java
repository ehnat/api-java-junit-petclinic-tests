package com.petclinic.data.databuilders;

import com.github.javafaker.Faker;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.petclinic.data.dto.Owner;
import com.petclinic.data.dto.PetResponse;

import java.util.List;

import static com.natpryce.makeiteasy.Property.newProperty;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class OwnerMakers {

    private static final Faker FAKER = new Faker();

    public static final Property<Owner, Integer> id = newProperty();
    public static final Property<Owner, String> firstName = newProperty();
    public static final Property<Owner, String> lastName = newProperty();
    public static final Property<Owner, String> address = newProperty();
    public static final Property<Owner, String> city = newProperty();
    public static final Property<Owner, String> telephone = newProperty();
    public static final Property<Owner, List<PetResponse>> pets = newProperty();

    public static final Instantiator<Owner> DEFAULT_OWNER_INSTANTIATOR = new Instantiator<Owner>() {
        @Override
        public Owner instantiate(PropertyLookup<Owner> lookup) {
            return new Owner(
                    lookup.valueOf(id, (Integer) null),
                    lookup.valueOf(firstName, FAKER.name().firstName()),
                    lookup.valueOf(lastName, FAKER.name().lastName()),
                    lookup.valueOf(address, FAKER.address().fullAddress()),
                    lookup.valueOf(city, FAKER.address().city()),
                    lookup.valueOf(telephone, randomNumeric(2)),
                    lookup.valueOf(pets, List.of())
            );
        }
    };
}
