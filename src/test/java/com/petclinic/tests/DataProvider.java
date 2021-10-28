package com.petclinic.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataProvider {

    static Stream<Arguments> getVetDetails() {
        return Stream.of(
                arguments(1, "James"),
                arguments(3, "Linda")
        );
    }

    static Stream<Arguments> getVisitDetails() {
        return Stream.of(
                arguments(1, "rabies shot"),
                arguments(3, "neutered")
        );
    }
}
