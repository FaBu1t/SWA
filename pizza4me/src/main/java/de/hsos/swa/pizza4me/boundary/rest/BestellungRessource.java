package de.hsos.swa.pizza4me.boundary.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.gateway.BestellungRepository;

@Path("/bestellung")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BestellungRessource {

    @Inject
    BestellungRepository service;

    @GET
    @Path("/{id}")
    public Response getBestellung(@PathParam("id") int id) {
        Bestellung bestellung = service.bestellungAnzeigen(id);
        if (bestellung != null) {
            return Response.ok(bestellung).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{kundenId}")
    public Response addBestellung(@PathParam("kundenId") int kundenId) {
        if (service.bestellungHinzufuegen(kundenId) != false) {
            return Response.ok().build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/addPizza/{bestellungId}/{pizzaId}/{menge}")
    public Response pizzaZuBestellungHinzufuegen(@PathParam("bestellungId") int bestellungId,
            @PathParam("pizzaId") int pizzaId, @PathParam("menge") int menge) {
        Bestellung neueBestellung = service.pizzaHinzufuegen(bestellungId, pizzaId, menge);
        if (neueBestellung != null) {
            return Response.ok(neueBestellung).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/Test/addKunde")
    public Response addKunde() {
        service.importKunde();
        return Response.ok().build();
    }
}
