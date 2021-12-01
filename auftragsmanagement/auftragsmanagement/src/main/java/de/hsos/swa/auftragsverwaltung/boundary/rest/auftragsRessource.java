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
import javax.ws.rs.core.Response.Status;
import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;
import de.hsos.swa.auftragsverwaltung.control.OrderService;
import de.hsos.swa.auftragsverwaltung.entity.Order;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuftragsRessource{

    @Inject
    OrderService orderService;

    @GET
    public Response getAll() {
        return Response.ok(orderService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") int id) {
        OrderDTO foundOrder = Order.Converter.toDto(orderService.getOrder(id));
        if (foundOrder != null) {
            return Response.ok(foundOrder).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{description}")
    public Response addOrder(@PathParam("description") String description) {
        return Response.ok(Order.Converter.toDto(orderService.createOrder(description))).build();
    }

    @PATCH
    public Response changeOrder(OrderDTO newOrder) {
        Order order = orderService.changeOrder(newOrder);
        if (order != null) {
            return Response.ok(Order.Converter.toDto(order)).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        Order order = orderService.deleteOrder(id);
        if (order != null) {
            return Response.ok(Order.Converter.toDto(order)).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }
}
