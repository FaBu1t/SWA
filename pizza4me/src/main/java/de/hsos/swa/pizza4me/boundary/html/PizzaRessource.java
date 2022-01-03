package de.hsos.swa.pizza4me.boundary.html;

import javax.ws.rs.GET;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.boundary.dto.PizzaDTO;
import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;

@Path("/index")
public class PizzaRessource {
    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();
    }

    @Inject
    @Named("PizzaRepo")
    PizzaService pizzaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response allePizzenHTML() {
        List<Pizza> allePizzen = pizzaService.allePizzenAbfragen();
        List<PizzaDTO> allePizzenDTOs = new ArrayList<>();
        if (allePizzen.isEmpty())
            return Response.noContent().build();
        for (Pizza p : allePizzen) {
            allePizzenDTOs.add(PizzaDTO.Converter.toPizzaDTO(p));
        }
        if (!allePizzenDTOs.isEmpty()) {
            return Response.ok(Templates.index().data("pizzen", allePizzen)).build();
        }

        return Response.noContent().build();
    }
}
