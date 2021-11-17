package de.hsos.swa.cocktailApp.gateway;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import de.hsos.swa.cocktailApp.entity.CocktailDTO;

@ApplicationScoped
public class CocktailGateway {
    private final String PATH = "https://www.thecocktaildb.com/api/json/v1/1/";

    public CocktailDTO getCocktailByID(int id) {
        String anfrage = PATH + "lookup.php?i=" + id;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);

        CocktailDTO cocktail = target.request().accept(MediaType.APPLICATION_JSON).get(CocktailDTO.class);
        restClient.close();
        return cocktail;

    }

    public CocktailDTO getCocktailByName(String name) {
        String anfrage = PATH + "search.php?s=" + name;
        System.out.println(anfrage);
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);

        CocktailDTO cocktail = target.request().accept(MediaType.APPLICATION_JSON).get(CocktailDTO.class);
        System.out.println(test);
        restClient.close();
        return test;
    }

    public CocktailDTO searchByIngredient(String ingredient) {
        String anfrage = PATH + "filter.php?i=" + ingredient;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);
        CocktailDTO cocktail = target.request().accept(MediaType.APPLICATION_JSON).get(CocktailDTO.class);
        restClient.close();
        return cocktail;

    }

}
