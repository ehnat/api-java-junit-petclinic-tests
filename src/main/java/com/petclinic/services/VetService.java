package com.petclinic.services;

import com.petclinic.dto.Vet;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class VetService {

    static List<Vet> getAllVets() {
        return Arrays.asList(given()
                .spec(RequestSpecs.basicSpec())
                .when()
                .get(Paths.VETS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Vet[].class));
    }

    static Vet getVet(int vetId) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .pathParam("vetId", vetId)
                .when()
                .get(Paths.VET)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Vet.class);
    }
}
