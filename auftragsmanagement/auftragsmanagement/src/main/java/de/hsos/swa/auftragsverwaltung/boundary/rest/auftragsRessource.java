package de.hsos.swa.auftragsverwaltung.boundary.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;
import de.hsos.swa.auftragsverwaltung.control.OrderService;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuftragsRessource {

    @Inject
    OrderService orderService;

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") int id) {
        return null;
    }

    @PUT
    public Response addOrder(OrderDTO newOrder) {
        return Response.ok(orderService.createOrder(newOrder)).build();
    }

    @PATCH
    public Response changeOrder(OrderDTO newOrder) {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        return null;
    }
}
