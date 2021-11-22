package com.petclinic.tests;

import com.petclinic.data.databuilders.OwnerMakers;
import com.petclinic.data.dto.Owner;
import com.petclinic.services.OwnerService;
import com.petclinic.tests.tags.SmokeParameterized;
import com.petclinic.tests.tags.Smoke;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.natpryce.makeiteasy.MakeItEasy.withNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Owners:")
class OwnerTest extends BaseTest {

    private static final int INITIAL_OWNERS_AMOUNT = 10;

    @Smoke
    @DisplayName("should return all owners")
    @Description("should return all owners")
    void shouldReturnAllOwners() {
        //when
        var allOwners = OwnerService.getAllOwners();

        //then
        assertAll("owners",
                () -> assertTrue(allOwners.size() > 0, "owners amount is greater than 0"),
                () -> assertTrue(allOwners.size() >= INITIAL_OWNERS_AMOUNT, "owners amount >= 10 (initial value)")
        );
    }

    @SmokeParameterized
    @DisplayName("should get an owner:")
    @Description("should get an owner:")
    @ParameterizedTest(name = "id and first name: {arguments}")
    @CsvSource(textBlock = """
                    1, George
                    3, Eduardo
            """)
    void shouldGetOwner(int ownerId, String firstName) {
        //when
        Owner owner = OwnerService.getOwner(ownerId);

        //then
        assertAll("get an owner:",
                () -> assertEquals(ownerId, owner.id(), () -> String.format("id is correct: %s", ownerId)),
                () -> assertEquals(firstName, owner.firstName(), () -> String.format("firstName is correct: %s", firstName))
        );
    }

    @Test
    @DisplayName("should add a new owner")
    @Description("should add a new owner")
    void shouldAddOwner() {
        //given
        var ownerRequest = make(
                an(OwnerMakers.DEFAULT_OWNER_INSTANTIATOR,
                        with(OwnerMakers.firstName, "Max"),
                        withNull(OwnerMakers.id))
        );

        //when
        var addedOwner = OwnerService.addOwner(ownerRequest);

        //then
        assertAll("added owner:",
                () -> assertTrue(addedOwner.id() > INITIAL_OWNERS_AMOUNT, "id > 10"),
                () -> assertEquals(ownerRequest.firstName(), addedOwner.firstName(), "first name = Max"),
                () -> assertTrue(OwnerService.getAllOwners().size() >= INITIAL_OWNERS_AMOUNT + 1, "owners amount >= 11")
        );
    }
}
