package de.hsos.swa.mocktailApp.boundary.rest;

import de.hsos.swa.mocktailApp.control.MocktailDTO;
import de.hsos.swa.mocktailApp.control.Rezeptverwaltung;

import java.util.List;

import javax.inject.Inject;
import javax.json.bind.*;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/mocktails")
public class KatalogRessource {

    @Inject
    Rezeptverwaltung verwaltung;

    @Tag(name = "search Mocktail (name)", description = "Search Mocktails with name")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public Response suchen(
            @Parameter(description = "Der Name des gesuchten Mocktails", required = true) @PathParam String name) {
        Jsonb jsonb = JsonbBuilder.create();
        List<MocktailDTO> mocktailDTOs = verwaltung.suchen(name);
        if (mocktailDTOs == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (mocktailDTOs.size() == 0)

        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        String result = jsonb.toJson(mocktailDTOs);

        return Response.ok(result).build();
    }

    @Tag(name = "search Mocktail (ID)", description = "Search Mocktails with ID")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response suchen(
            @Parameter(description = "Die ID des gesuchten Mocktails", required = true) @PathParam int id) {
        Jsonb jsonb = JsonbBuilder.create();
        MocktailDTO mocktail = verwaltung.suchen(id);
        if (mocktail == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(jsonb.toJson(mocktail)).build();
    }

    @Tag(name = "add Mocktail")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)

    public Response add(String mocktailInput) {
        Jsonb jsonb = JsonbBuilder.create();
        System.out.println(mocktailInput);
        MocktailDTO newMocktail = jsonb.fromJson(mocktailInput, MocktailDTO.class);
        /*
         * if (newMocktail != null) { System.out.println(newMocktail.toString()); } else
         * { System.out.println("Is Null"); }
         */
        if (verwaltung.create(newMocktail)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Tag(name = "delete Mocktail")
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(
            @Parameter(description = "Die ID des zu löschenden Mocktails", required = true) @PathParam int id) {

        if (verwaltung.delete(id)) {
            return Response.ok().build();
        } else
            return Response.status(Status.BAD_REQUEST).build();

    }

    @Tag(name = "change existing Mocktail")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response change(String mocktailInput) {
        Jsonb jsonb = JsonbBuilder.create();
        MocktailDTO newMocktail = jsonb.fromJson(mocktailInput, MocktailDTO.class);
        if (verwaltung.change(newMocktail)) {
            return Response.ok(newMocktail).build();
        }
        return Response.status(Status.BAD_REQUEST).build();

    }
}
