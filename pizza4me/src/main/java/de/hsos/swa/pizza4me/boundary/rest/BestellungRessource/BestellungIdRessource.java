package de.hsos.swa.pizza4me.boundary.rest.BestellungRessource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;

import de.hsos.swa.pizza4me.boundary.dto.BestellpostenDTOPizzaId;
import de.hsos.swa.pizza4me.boundary.dto.BestellungDTO;
import de.hsos.swa.pizza4me.boundary.dto.PizzaDTO;
import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Pizza;

@Path("/bestellung/{bestellungId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BestellungIdRessource {

    @Inject
    @Named("BestellungRepos")
    BestellungService service;

    @Inject
    @Named("PizzaRepo")
    PizzaService servicePizza;

    @GET
    public Response getBestellung(@PathParam("bestellungId") int id) {
        Bestellung bestellung = service.bestellungAnzeigen(id);
        if (bestellung != null) {
            return Response.ok(BestellungDTO.Converter.toBestellungDTO(bestellung)).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @POST
    @Operation(description = "Pizza zu Bestellung hinzufügen")
    public Response pizzaZuBestellungHinzufuegen(@PathParam("bestellungId") int bestellungId,
            BestellpostenDTOPizzaId neuerBestellpostenDTO) {

        if (service.isAbgeschlossen(bestellungId) == true) {
            return Response.status(Status.FORBIDDEN)
                    .entity("Die Bestellung ist bereits abgeschlossen und darf nicht mehr verändert werden!").build();
        }

        Pizza pizza = servicePizza.suchePizzaNachId(neuerBestellpostenDTO.pizza);
        if (pizza != null) {
            Bestellung neueBestellung = service.bestellpostenHinzufuegen(bestellungId,
                    BestellpostenDTOPizzaId.Converter
                            .toBestellposten(neuerBestellpostenDTO, PizzaDTO.Converter.toPizzaDTO(pizza)));
            if (neueBestellung != null) {
                return Response.ok(neueBestellung).build();

            }
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/abschliessen")
    @Operation(description = "Bestellung abschließen")
    public Response bestellungAbschliessen(@PathParam("bestellungId") int bestellungId) {
        if (service.isAbgeschlossen(bestellungId) == true) {
            return Response.status(Status.FORBIDDEN)
                    .entity("Die Bestellung ist bereits abgeschlossen und darf nicht mehr verändert werden!").build();
        }
        return Response.ok(service.bestellungAbschliessen(bestellungId)).build();
    }

    @PUT
    public Response putBestellung() {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @DELETE
    public Response deleteBestellung(@PathParam("bestellungId") int id) {
        if (service.isAbgeschlossen(id) == true) {
            return Response.status(Status.FORBIDDEN)
                    .entity("Die Bestellung ist bereits abgeschlossen und darf nicht mehr verändert werden!").build();
        }
        return Response.ok(service.bestellungLoeschen(id)).build();
    }

}
