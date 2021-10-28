package com.petclinic.services;

import com.petclinic.data.dto.Visit;
import com.petclinic.specs.RequestSpecs;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class VisitService {

    public static List<Visit> getAllVisits() {
        return List.of(given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .when()
                .get(Paths.VISITS)
                .then()
                .statusCode(SC_OK)
                .extract().as(Visit[].class));
    }

    public static Visit getVisit(int visitId) {
        return given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .pathParam("visitId", visitId)
                .when()
                .get(Paths.VISIT)
                .then()
                .statusCode(SC_OK)
                .extract().response().as(Visit.class);
    }

    public static Visit addVisit(Visit requestBody) {
        return given()
                .spec(RequestSpecs.basicSpecWithTrafficLogging())
                .body(requestBody)
                .when()
                .post(Paths.VISITS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().as(Visit.class);
    }
}
