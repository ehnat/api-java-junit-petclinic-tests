package com.petclinic.services;

import com.petclinic.data.dto.Vet;
import com.petclinic.specs.RequestSpecs;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class VetService {

    public static List<Vet> getAllVets() {
        return Arrays.asList(given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .when()
                .get(Paths.VETS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Vet[].class));
    }

    public static Vet getVet(int vetId) {
        return given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .pathParam("vetId", vetId)
                .when()
                .get(Paths.VET)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Vet.class);
    }
}
