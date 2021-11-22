package com.petclinic.tests;

import com.petclinic.data.dto.PetType;
import com.petclinic.services.PetService;
import com.petclinic.tests.tags.SmokeParameterized;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("PetTypes:")
public class PetTypeTest extends BaseTest {

    @SmokeParameterized
    @MethodSource("getPetTypesDetails")
    @DisplayName("should get a pet type:")
    @ParameterizedTest(name = "id and name: {arguments}")
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
