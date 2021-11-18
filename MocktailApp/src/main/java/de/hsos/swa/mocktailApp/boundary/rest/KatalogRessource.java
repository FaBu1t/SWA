package de.hsos.swa.mocktailApp.boundary.rest;

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
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.responses.*;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/mocktails")
@Produces(MediaType.APPLICATION_JSON)
public class KatalogRessource {

    @Inject
    CocktailGateway cocktailGateway;

    @Inject
    Rezeptverwaltung verwaltung;

    @GET
    @Timeout(250)
    // @Timed(name = "getMocktailTime", description = "Metrics to monitor the times
    // of processItem method.", unit = MetricUnits.MINUTES, absolute = true)
    @Tag(name = "get Mocktail (name)", description = "Mocktail searchth name")

    @Path("/name/{name}")
    @APIResponses(value = {
            @APIResponse(responseCode = "404", description = "Mocktail nicht gefunden", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "200", description = "Mocktail(s) gefunden", content = @Content(mediaType = "application/json")) })

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

    @GET
    @Timeout(250)
    @Tag(name = "get Mocktail (ID)", description = "Search Mocktails with ID")
    @Operation(summary = "gets Mocktails", description = "gets Mocktails with ID")
    // @Timed(name = "getMocktailTime", description = "Metrics to monitor the timeas
    // of Mocktail search", unit = MetricUnits.MINUTES, absolute = true)
    @Path("/id/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "404", description = "Mocktail nicht gefunden", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "200", description = "Mocktail gefunden", content = @Content(mediaType = "application/json")) })
    public Response suchen(
            @Parameter(description = "Die ID des gesuchten Mocktails", required = true) @PathParam int id) {
        Jsonb jsonb = JsonbBuilder.create();
        MocktailDTO mocktail = verwaltung.suchen(id);
        if (mocktail == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(jsonb.toJson(mocktail)).build();
    }

    @PUT
    @Retry(maxRetries = 4)
    @Tag(name = "add Mocktail")
    @Operation(summary = "add Mocktail", description = "add Mocktail with id, name, Zutaten, Autor")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Erfolgreich erstellt", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "400", description = "Nicht erstellt", content = @Content(mediaType = "application/json")) })

    public Response add(MocktailDTO mocktailInput) {
        // Jsonb jsonb = JsonbBuilder.create();
        // MocktailDTO newMocktail = jsonb.fromJson(mocktailInput, MocktailDTO.class);
        /*
         * if (newMocktail != null) { System.out.println(newMocktail.toString()); } else
         * { System.out.println("Is Null"); }
         */
        if (verwaltung.create(mocktailInput)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Timeout(250)
    @Tag(name = "delete Mocktail")
    @Operation(summary = "delete Mocktail", description = "delete Mocktail with ID")
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Mocktail gelöscht", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "400", description = "Mocktail nicht gelöscht", content = @Content(mediaType = "application/json")) })
    public Response delete(
            @Parameter(description = "Die ID des zu löschenden Mocktails", required = true) @PathParam int id) {

        if (verwaltung.delete(id)) {
            return Response.ok().build();
        } else
            return Response.status(Status.BAD_REQUEST).build();
    }

    @POST
    @Retry(maxRetries = 4)
    @Tag(name = "change existing Mocktail")
    @Operation(summary = "change Mocktail", description = "change existing Mocktail with ID, Name, Zutaten, Autor")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Mocktail geändert", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "400", description = "Mocktail nicht geändert", content = @Content(mediaType = "application/json")) })
    public Response change(MocktailDTO mocktailInput) {
        /*
         * Jsonb jsonb = JsonbBuilder.create(); MocktailDTO newMocktail =
         * jsonb.fromJson(mocktailInput, MocktailDTO.class);
         */
        if (verwaltung.change(mocktailInput)) {
            return Response.ok(mocktailInput).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

}
