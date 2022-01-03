package de.hsos.swa.pizza4me.boundary.rest.BestellungRessource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Pizza;

@RequestScoped
@Transactional(value = TxType.REQUIRES_NEW)
@Path("/bestellung/kundenId/{kundenId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class BestellungKundenIdRessource {

    @Inject
    @Named("BestellungRepos")
    BestellungService service;

    @Inject
    @Named("PizzaRepo")
    PizzaService servicePizza;

    @GET
    @RolesAllowed("KundIn")
    public Response getBestellung(@PathParam("kundenId") int kundenId) {
        List<List<Bestellung>> bestellung = service.alleBestellungenfureKundenAnzeigen(kundenId);
        if (bestellung != null) {
            return Response.ok(bestellung).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    @RolesAllowed("KundIn")
    public Response addBestellung(@PathParam("kundenId") int kundenId) {
        Bestellung bestellung = service.bestellungHinzufuegen(kundenId);
        if (bestellung != null) {
            return Response.ok(bestellung).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    @RolesAllowed("KundIn")
    @Path("/pizza")
    public Response addBestellungMitPizza(@PathParam("kundenId") int kundenId,
            BestellpostenDTOPizzaId neuerBestellpostenDTO) {
        Bestellung bestellung = service.bestellungHinzufuegen(kundenId);
        if (bestellung != null) {
            Pizza pizza = servicePizza.suchePizzaNachId(neuerBestellpostenDTO.pizza);
            if (pizza != null) {
                Bestellung neueBestellung = service.bestellpostenHinzufuegen(bestellung.getId(),
                        BestellpostenDTOPizzaId.Converter
                                .toBestellposten(neuerBestellpostenDTO, pizza));
                if (neueBestellung != null) {
                    return Response.ok(neueBestellung).build();
                }
            }
        }
        return Response.status(Status.BAD_REQUEST).build();
    }
}
