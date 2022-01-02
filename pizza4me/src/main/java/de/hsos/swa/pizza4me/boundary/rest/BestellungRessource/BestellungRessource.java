package de.hsos.swa.pizza4me.boundary.rest.BestellungRessource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.transaction.Transactional.TxType;
import de.hsos.swa.pizza4me.control.BestellungService;

@RequestScoped
@Path("/bestellung")
@Transactional(value = TxType.REQUIRES_NEW)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BestellungRessource {

    @Inject
    @Named("BestellungRepos")
    BestellungService service;

    @GET
    public Response getAll() {
        return Response.ok(service.alleBestellungenAnzeigen()).build();
    }

    @PUT
    public Response putAllBestellung() {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @POST
    public Response postAllBestellung() {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @DELETE
    public Response DeleteAllBestellung() {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

}
