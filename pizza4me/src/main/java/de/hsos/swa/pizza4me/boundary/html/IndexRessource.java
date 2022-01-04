package de.hsos.swa.pizza4me.boundary.html;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.boundary.dto.PizzaDTO;
import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;
import de.hsos.swa.pizza4me.entity.Pizza;

@Path("/index")
@Produces(MediaType.TEXT_HTML)
public class IndexRessource {
    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();

        public static native TemplateInstance index_kundIn();
    }

    @Inject
    @Named("BestellungRepos")
    BestellungService service;

    @Inject
    @Named("PizzaRepo")
    PizzaService pizzaService;

    @Inject
    @Named("KundenRepo")
    KundenService kundenService;

    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        return Response.seeOther(UriBuilder.fromPath("/index").build())
                .build();
    }

    @GET
    @Path("/kunde/{kundenId}/bestellung/{bestellungId}")
    public Response allePizzenHTML(@PathParam("kundenId") int kundenId, @PathParam("bestellungId") int bestellungId) {
        List<Pizza> allePizzen = pizzaService.allePizzenAbfragen();
        List<PizzaDTO> allePizzenDTOs = new ArrayList<>();
        if (allePizzen.isEmpty())
            return Response.noContent().build();
        for (Pizza p : allePizzen) {
            allePizzenDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }
        if (!allePizzenDTOs.isEmpty()) {
            Bestellung bestellung = service.bestellungAnzeigen(bestellungId);
            if (bestellung != null) {
                List<Bestellposten> bestellposten = bestellung.getBestellposten();
                double gesamtpreis = 0;
                for (Bestellposten bp : bestellposten) {
                    gesamtpreis += bp.gesamtpreis();
                }
                DecimalFormat f = new DecimalFormat("#0.00");
                return Response
                        .ok(Templates.index_kundIn().data("pizzen", allePizzen).data("bestellposten", bestellposten)
                                .data("bestellungId", bestellung.getId()).data("gesamtpreis", f.format(gesamtpreis))
                                .data("kundenId", kundenId))
                        .build();
            }
            return Response
                    .ok(Templates.index_kundIn().data("pizzen", allePizzen).data("bestellposten", null)
                            .data("bestellungId",
                                    0)
                            .data("gesamtpreis", "00.00").data("kundenId", kundenId))
                    .build();
        }

        return Response.noContent().build();
    }

    @GET
    @Path("/kunde/{kundenId}")
    public Response indexKunde(@PathParam("kundenId") int kundenId) {
        List<Pizza> allePizzen = pizzaService.allePizzenAbfragen();
        List<PizzaDTO> allePizzenDTOs = new ArrayList<>();
        if (allePizzen.isEmpty())
            return Response.noContent().build();
        for (Pizza p : allePizzen) {
            allePizzenDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }
        if (!allePizzenDTOs.isEmpty()) {
            return Response
                    .ok(Templates.index_kundIn().data("pizzen", allePizzen).data("bestellposten", null)
                            .data("bestellungId",
                                    0)
                            .data("gesamtpreis", "00.00").data("kundenId", kundenId))
                    .build();
        }
        return Response.noContent().build();
    }

    @GET
    public Response index() {
        List<Pizza> allePizzen = pizzaService.allePizzenAbfragen();
        List<PizzaDTO> allePizzenDTOs = new ArrayList<>();
        if (allePizzen.isEmpty())
            return Response.noContent().build();
        for (Pizza p : allePizzen) {
            allePizzenDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }
        if (!allePizzenDTOs.isEmpty()) {
            return Response
                    .ok(Templates.index().data("pizzen", allePizzen).data("bestellposten", null).data("bestellungId",
                            0).data("gesamtpreis", "00.00").data("kundenId", 0))
                    .build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("/kunde/{kundenId}/pizza")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBestellungMitPizzaHTML(@PathParam("kundenId") int kundenId,
            @FormParam("menge") int menge, @FormParam("pizza") Long pizzaId) {
        Kunde kunde = kundenService.kundeAnzeigen(kundenId);
        int bestellungId = 0;
        if (kunde != null) {
            for (Bestellung b : kunde.getBestellungen()) {
                if (b.isBestellt() == false) {
                    bestellungId = b.getId();
                }
            }
        }
        Bestellung bestellung;
        if (bestellungId == 0) {
            bestellung = service.bestellungHinzufuegen(kundenId);
        } else {
            bestellung = service.bestellungAnzeigen(bestellungId);
        }
        if (bestellung != null) {
            Pizza pizza = pizzaService.suchePizzaNachId(pizzaId);
            if (pizza != null) {
                Bestellposten bp = new Bestellposten(pizza, menge);
                if (service.bestellpostenHinzufuegen(bestellung.getId(), bp) != null) {
                    return Response
                            .seeOther(UriBuilder
                                    .fromPath("/index/kunde/" + kundenId + "/bestellung/" + bestellung.getId()).build())
                            .build();
                }
            }
        }
        return Response.seeOther(UriBuilder.fromPath("/index/kunde/" + kundenId).build()).build();
    }

    @POST
    @Path("/kunde/{kundenId}/bestellung/{bestellungId}/abschliessen")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bestellungAbschliessen(@PathParam("kundenId") int kundenId,
            @PathParam("bestellungId") int bestellungId) {
        if (bestellungId != 0) {
            service.bestellungAbschliessen(bestellungId);
        }
        return Response.seeOther(UriBuilder.fromPath("/index/kunde/" + kundenId).build())
                .build();
    }

}
