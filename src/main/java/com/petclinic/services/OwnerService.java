package com.petclinic.services;

import com.petclinic.dto.Owner;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class OwnerService {

    static List<Owner> getAllOwners() {
        return Arrays.asList(given()
                .spec(RequestSpecs.basicSpec())
                .when()
                .get(Paths.OWNERS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Owner[].class));
    }

    static Owner getOwner(int ownerId) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .pathParam("ownerId", ownerId)
                .when()
                .get(Paths.OWNER)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Owner.class);
    }

    static Owner addOwner(Owner requestBody) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
                .when()
                .post(Paths.OWNERS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().as(Owner.class);
    }
}
