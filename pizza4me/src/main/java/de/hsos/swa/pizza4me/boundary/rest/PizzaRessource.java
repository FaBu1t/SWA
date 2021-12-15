package de.hsos.swa.pizza4me.boundary.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.boundary.dto.PizzaDTO;
import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;
import io.quarkus.logging.Log;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PizzaRessource {

    @Inject
    @Named("PizzaRepo")
    PizzaService pizzaService;

    @GET
    public Response allePizzen() {
        List<Pizza> allePizzen = pizzaService.allePizzenAbfragen();
        List<PizzaDTO> allePizzenDTOs = new ArrayList<>();
        if (allePizzen.isEmpty())
            return Response.noContent().build();
        for (Pizza p : allePizzen) {
            allePizzenDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }
        if (!allePizzenDTOs.isEmpty()) {
            return Response.ok().entity(allePizzenDTOs).build();
        }

        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response suchePizzaNachId(@PathParam Long id) {

        Pizza pizza = pizzaService.suchePizzaNachId(id);

        if (pizza == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        return Response.ok(PizzaDTO.Converter.toPizzaDTO(pizza)).build();
    }

    @GET
    @Path("name/{name}")
    public Response suchePizzaNachName(@PathParam String name) {
        // System.out.println(name);
        List<Pizza> pizzen = pizzaService.suchePizzaNachName(name);
        List<PizzaDTO> pizzaDTOs = new ArrayList<>();
        for (Pizza p : pizzen) {
            pizzaDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }

        if (!pizzaDTOs.isEmpty()) {

            return Response.ok(pizzaDTOs).build();
        }

        return Response.noContent().build();

    }

}
