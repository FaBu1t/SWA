package de.hsos.swa.mocktailApp.boundary.rest;

import de.hsos.swa.mocktailApp.control.Rezeptverwaltung;
import de.hsos.swa.mocktailApp.entity.Mocktail;

import java.util.List;

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
    @Path("/suchen/name/{name}")
    public String suchen(@PathParam String name) {
        System.out.println("Get suchen " + name);
        List<Mocktail> mocktail = verwaltung.suchen(name);
        if (mocktail == null) {
            return "Nichts Gefunden";
        }
        if (mocktail.size() == 0) {
            return "is empty";
        }

        return mocktail.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/suchen/id/{id}")
    public String suchen(@PathParam int id) {
        Mocktail mocktail = verwaltung.suchen(id);
        if (mocktail == null) {
            return "Nicht Gefunden";
        }
        return mocktail.toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add/{id}/{name}/{zutaten}/{autor}")
    public void add(@PathParam int id, @PathParam String name, @PathParam String zutaten, @PathParam String autor) {
        System.out.println("adding");
        String[] MockZutaten = zutaten.split("-");
        verwaltung.create(id, name, MockZutaten, autor);
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
    @Path("/change/{id}/{name}/{zutaten}/{autor}")
    public void change(@PathParam int id, @PathParam String name, @PathParam String zutaten, @PathParam String autor) {
        String[] MockZutaten = zutaten.split("-");
        verwaltung.change(id, name, MockZutaten, autor);

    }
}
