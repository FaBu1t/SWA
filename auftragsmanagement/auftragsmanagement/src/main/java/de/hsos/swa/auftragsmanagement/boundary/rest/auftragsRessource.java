package de.hsos.swa.auftragsmanagement.boundary.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.auftragsmanagement.boundary.dto.orderDTO;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class auftragsRessource {

    @PUT
    public Response addOrder(orderDTO newOrder) {
        return null;
    }

    @POST
    public Response changeOrder(orderDTO newOrder) {
        return null;
    }

    @GET
    public Response getOrder(int orderId) {
        return null;
    }

    @DELETE
    public Response deleteOrder(int orderId) {
        return null;
    }
}
