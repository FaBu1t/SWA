package de.hsos.swa.mocktailApp.boundary.rest;

import de.hsos.swa.mocktailApp.control.Rezeptverwaltung;
import de.hsos.swa.mocktailApp.entity.Mocktail;

import java.util.List;

import javax.inject.Inject;
import javax.json.bind.*;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/mocktails")
public class KatalogRessource {

    @Inject
    Rezeptverwaltung verwaltung;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public String suchen(@PathParam String name) {
        Jsonb jsonb = JsonbBuilder.create();
        List<Mocktail> mocktail = verwaltung.suchen(name);
        if (mocktail == null) {
            return "Nichts Gefunden";
        }
        if (mocktail.size() == 0) {
            return "is empty";
        }
        String result = jsonb.toJson(mocktail);

        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public String suchen(@PathParam int id) {
        Jsonb jsonb = JsonbBuilder.create();
        Mocktail mocktail = verwaltung.suchen(id);
        if (mocktail == null) {
            return "Nicht Gefunden";
        }
        return jsonb.toJson(mocktail);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)

    public String add(String mocktailInput) {
        Jsonb jsonb = JsonbBuilder.create();
        System.out.println(mocktailInput);
        Mocktail newMocktail = jsonb.fromJson(mocktailInput, Mocktail.class);

        if (newMocktail != null) {
            System.out.println(newMocktail.toString());
        } else {
            System.out.println("Is Null");
        }

        if (verwaltung.create(newMocktail)) {
            return "Mocktail hinzugefuegt!";
        }
        return "Mocktail wurde nicht hinzugefügt";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam int id) {

        if (verwaltung.delete(id)) {
            return "deleted";
        } else
            return "not deleted";

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String change(String mocktailInput) {
        Jsonb jsonb = JsonbBuilder.create();
        Mocktail newMocktail = jsonb.fromJson(mocktailInput, Mocktail.class);
        if (verwaltung.change(newMocktail)) {
            return "Mocktail geändert!";
        }
        return "Mocktail konnte nicht geändert werden";

    }
}
