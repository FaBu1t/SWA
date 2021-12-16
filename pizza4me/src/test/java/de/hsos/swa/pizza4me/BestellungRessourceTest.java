package de.hsos.swa.pizza4me;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BestellungRessourceTest {
    @Test
    public void testAddKunde() {
        given()
                .when().get("/bestellung/Test/addKunde")
                .then()
                .statusCode(200);
        given()
                .when().put("/bestellung/1")
                .then()
                .statusCode(200);
        given()
                .when().put("bestellung/addPizza/1000/1/2")
                .then()
                .statusCode(200);
        given()
                .when().get("bestellung/1000")
                .then()
                .statusCode(200);
    }
}
