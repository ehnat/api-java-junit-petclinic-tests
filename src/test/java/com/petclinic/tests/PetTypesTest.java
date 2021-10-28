package com.petclinic.tests;

import com.petclinic.data.dto.PetType;
import com.petclinic.services.PetService;
import com.petclinic.tests.tags.SmokeParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("PetTypes:")
public class PetTypesTest {

    @SmokeParameterizedTest
    @MethodSource("getPetTypesDetails")
    @DisplayName("should get a pet type:")
    void shouldGetPetType(int petTypeId, String name) {
        //when
        PetType petType = PetService.getPetType(petTypeId);

        //then
        assertAll("get pet type:",
                () -> assertEquals(name, petType.name(), () -> String.format("name is correct: %s", name))
        );
    }

    private static Stream<Arguments> getPetTypesDetails() {
        return Stream.of(
                arguments(1, "cat"),
                arguments(2, "dog"),
                arguments(3, "lizard"),
                arguments(4, "snake"),
                arguments(5, "bird"),
                arguments(6, "hamster")
        );
    }
}