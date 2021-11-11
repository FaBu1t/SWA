package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class KatalogRessourceTest {

    @Test
    public void testAddMocktail() {
        given().when().get("/mocktails/add/2/Apfelsaft/apfel-saft/ich").then().body(is("Mocktail hinzugefuegt!"));
    }

    @Test
    public void testChangeMocktail() {
        given().when().get("/mocktails/change/1/keinOrangensaft/wasser/auchIch").then().body(is("Mocktail geändert!"));
    }

    @Test
    public void testAddWrongMocktail() {
        given().when().get("/mocktails/add/1/Apfelsaft/apfel-saft/ich").then()
                .body(is("Mocktail wurde nicht hinzugefügt"));
    }

    @Test
    public void testChangeWrongMocktail() {
        given().when().get("/mocktails/change/11/keinOrangensaft/wasser/auchIch").then()
                .body(is("Mocktail konnte nicht geändert werden"));
    }
}