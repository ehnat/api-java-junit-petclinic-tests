package com.petclinic.services;

import com.petclinic.dto.Visit;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class VisitService {

    static List<Visit> getAllVisits() {
        return List.of(given()
                .spec(RequestSpecs.basicSpec())
                .when()
                .get(Paths.VISITS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Visit[].class));
    }

    static Visit getVisit(int visitId) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .pathParam("visitId", visitId)
                .when()
                .get(Paths.VISIT)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Visit.class);
    }

    static Visit addVisit(Visit requestBody) {
        return given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
                .when()
                .post(Paths.VISITS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().as(Visit.class);
    }
}
