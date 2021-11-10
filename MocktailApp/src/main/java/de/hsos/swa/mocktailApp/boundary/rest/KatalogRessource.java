package de.hsos.swa.mocktailApp.boundary.rest;

import de.hsos.swa.mocktailApp.control.Rezeptverwaltung;
import de.hsos.swa.mocktailApp.entity.Mocktail;

import javax.inject.Inject;
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
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/suchen")
    public String suchen(@PathParam String name) {
        // return verwaltung.suchen(name).toString();
        return "suchen";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/suchen/id/{id}")
    public Mocktail suchen(@PathParam int id) {
        Mocktail mocktail = verwaltung.suchen(id);
        if (mocktail == null) {
            return null;
        }
        return mocktail;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add/{id}/{name}/{zutat}/{autor}")
    public void add(@PathParam int id, @PathParam String name, @PathParam String zutat, @PathParam String autor) {
        System.out.println("adding");
        String[] zutaten = { zutat };
        verwaltung.create(id, name, zutaten, autor);

    }

    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam int id) {

        if (verwaltung.delete(id)) {
            return "deleted";
        } else
            return "not deleted";

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/change/{id}/{name}/{zutat}/{autor}")
    public void change(@PathParam int id, @PathParam String name, @PathParam String zutat, @PathParam String autor) {
        String[] zutaten = { zutat };
        verwaltung.change(id, name, zutaten, autor);

    }
}
