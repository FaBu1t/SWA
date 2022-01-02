package de.hsos.swa.pizza4me.boundary.rest.BestellungRessource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
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
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import de.hsos.swa.pizza4me.boundary.dto.BestellpostenDTOPizzaId;
import de.hsos.swa.pizza4me.boundary.dto.PizzaDTO;
import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;

@RequestScoped
@Transactional(value = TxType.REQUIRES_NEW)
@Path("/bestellung/bestellposten/{bestellpostenId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BestellungBestellpostenIdRessource {

    @Inject
    @Named("BestellungRepos")
    BestellungService service;

    @Inject
    @Named("PizzaRepo")
    PizzaService servicePizza;

    @GET
    public Response getBestellposten(@PathParam("bestellpostenId") int id) {
        return null;
    }

    // Bestellposten hinzufügen
    @PUT
    public Response putBestellposten(@PathParam("bestellpostenId") int id) {
        return null;
    }

    // BestellpostenId = BestellungID !! Ressource ändern
    @POST
    public Response postBestellposten(@PathParam("bestellpostenId") int id,
            BestellpostenDTOPizzaId neuerBestellposten) {
        int bestellungId = service.findBestellungId(id);
        if (service.isAbgeschlossen(bestellungId) == true) {
            return Response.status(Status.FORBIDDEN)
                    .entity("Bestellung ist bereits abgeschlossen und darf nicht mehr verändert werden").build();
        }
        Pizza pizza = servicePizza.suchePizzaNachId(neuerBestellposten.pizza);
        if (pizza != null) {
            return Response
                    .ok(service.bestellpostenAendern(id,
                            BestellpostenDTOPizzaId.Converter.toBestellposten(neuerBestellposten,
                                    pizza)))
                    .build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @DELETE
    public Response deleteBestellposten(@PathParam("bestellpostenId") int id) {
        int bestellungId = service.findBestellungId(id);
        if (service.isAbgeschlossen(bestellungId) == true) {
            return Response.status(Status.FORBIDDEN)
                    .entity("Bestellung ist bereits abgeschlossen und darf nicht mehr verändert werden").build();
        }
        return Response.ok(service.bestellpostenLoeschen(id)).build();
    }
}
