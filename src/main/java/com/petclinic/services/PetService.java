package com.petclinic.services;

import com.petclinic.dto.Pet;
import com.petclinic.dto.PetType;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class PetService {

    static PetType getPetType(int petTypeId) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .pathParam("petTypeId", petTypeId)
                .when()
                .get(Paths.PET_TYPE)
                .then()
                .statusCode(SC_OK)
                .extract().response().<PetType>as(PetType.class);
    }

    static List<Pet> getAllPets() {
        return Arrays.asList(given()
                .spec(RequestSpecs.basicSpec())
                .when()
                .get(Paths.PETS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Pet[].class));
    }

    static Pet getPet(int petId) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .pathParam("id", petId)
                .when()
                .get(Paths.PET)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Pet.class);
    }

    static Pet addPet(Pet requestBody) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
                .when()
                .post(Paths.PETS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().as(Pet.class);
    }
}
