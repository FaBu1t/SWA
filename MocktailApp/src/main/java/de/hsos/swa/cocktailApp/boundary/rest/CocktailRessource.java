package de.hsos.swa.cocktailApp.boundary.rest;

import de.hsos.swa.cocktailApp.control.Controler;
import de.hsos.swa.cocktailApp.entity.CocktailDTO;
import de.hsos.swa.cocktailApp.gateway.CocktailGateway;
import de.hsos.swa.mocktailApp.control.Rezeptverwaltung;
import de.hsos.swa.mocktailApp.entity.MocktailDTO;

import java.util.List;

import javax.inject.Inject;
import javax.json.bind.*;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.responses.*;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/cocktail")
@Produces(MediaType.APPLICATION_JSON)
public class CocktailRessource {
    @Inject
    Controler control;

    @GET
    @Path("/{name}")
    public Response getCocktailByName(@PathParam String name) {
        // System.out.println(name);
        Jsonb jsonb = JsonbBuilder.create();
        List<CocktailDTO> cocktails = control.getCocktailByName(name);
        System.out.println(cocktails);
        String result = jsonb.toJson(cocktails);
        if (cocktails != null) {
            return Response.ok(result).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/ingedient/{name}")
    public Response getCocktailByIngredient(@PathParam String name) {
        // System.out.println(name);

        List<CocktailDTO> cocktails = control.searchCocktailByIngredient(name);
        System.out.println(cocktails);
        if (cocktails != null) {
            return Response.ok(cocktails).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/id/{id}")
    public Response getCocktailByID(@PathParam int id) {
        // System.out.println(name);

        List<CocktailDTO> cocktails = control.getCocktailByID(id);
        if (cocktails != null) {
            return Response.ok(cocktails).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

}
