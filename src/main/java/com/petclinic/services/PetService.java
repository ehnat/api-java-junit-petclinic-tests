package com.petclinic.services;

import com.petclinic.data.dto.Pet;
import com.petclinic.data.dto.PetType;
import com.petclinic.specs.RequestSpecs;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class PetService {

    public static PetType getPetType(int petTypeId) {
        return given()
                .spec(RequestSpecs.basicSpecWithoutTrafficLogging())
                .pathParam("petTypeId", petTypeId)
                .when()
                .get(Paths.PET_TYPE)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(PetType.class);
    }

    public static List<Pet> getAllPets() {
        return Arrays.asList(given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .when()
                .get(Paths.PETS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Pet[].class));
    }

    public static Pet getPet(int petId) {
        return given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .pathParam("id", petId)
                .when()
                .get(Paths.PET)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Pet.class);
    }

    public static Pet addPet(Pet requestBody) {
        return given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .body(requestBody)
                .when()
                .post(Paths.PETS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().as(Pet.class);
    }
}
