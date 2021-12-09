package de.hsos.swa.pizza4me.boundary.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PizzaRessource {

    @Inject
    @Named("PizzaRepo")
    PizzaService pizzaService;


    @GET
    public Response allePizzen(){
        List<Pizza> allePizzen= pizzaService.allePizzenAbfragen();

        return Response.noContent().build();
    }




}
