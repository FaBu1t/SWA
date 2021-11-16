package de.hsos.swa.mocktailApp.gateway;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import de.hsos.swa.mocktailApp.entity.CocktailDTO;

public class CocktailGateway {

    public CocktailDTO getCocktailByID(int id) {
        String anfrage = "lookup.php?i=" + id;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target("www.thecocktaildb.com/api").path("json").path("v1").path("1")
                .path(anfrage);

        restClient.close();

        return null;

    }

    public CocktailDTO getCocktailByName(String name) {
        String anfrage = "search.php?s=" + name;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target("www.thecocktaildb.com/api").path("json").path("v1").path("1")
                .path(anfrage);

        restClient.close();

        return null;

    }

    public CocktailDTO searchByIngredient(String ingredient) {
        String anfrage = "filter.php?i=" + ingredient;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target("www.thecocktaildb.com/api").path("json").path("v1").path("1")
                .path(anfrage);

        restClient.close();

        return null;

    }

}
