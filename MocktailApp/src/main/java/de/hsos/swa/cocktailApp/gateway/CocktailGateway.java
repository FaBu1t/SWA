package de.hsos.swa.cocktailApp.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import de.hsos.swa.cocktailApp.control.DTOFactory;
import de.hsos.swa.cocktailApp.entity.CocktailDTO;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class CocktailGateway {
    private DTOFactory factory = new DTOFactory();
    private final String PATH = "https://www.thecocktaildb.com/api/json/v1/1/";

    public List<CocktailDTO> getCocktailByID(int id) {
        String anfrage = PATH + "lookup.php?i=" + id;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);

        JsonObject JsonCocktail = target.request().accept(MediaType.APPLICATION_JSON).get(JsonObject.class);
        restClient.close();
        return factory.getCocktailDto(JsonCocktail);

    }

    public List<CocktailDTO> getCocktailByName(String name) {
        String anfrage = PATH + "search.php?s=" + name;
        System.out.println(anfrage);
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);

        JsonObject JsonCocktail = target.request().accept(MediaType.APPLICATION_JSON).get(JsonObject.class);
        System.out.println(JsonCocktail);
        restClient.close();
        return factory.getCocktailDto(JsonCocktail);
    }

    public List<CocktailDTO> searchByIngredient(String ingredient) {
        String anfrage = PATH + "filter.php?i=" + ingredient;
        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target(anfrage);
        JsonObject JsonCocktail = target.request().accept(MediaType.APPLICATION_JSON).get(JsonObject.class);
        restClient.close();
        return factory.getCocktailDto(JsonCocktail);

    }

}
