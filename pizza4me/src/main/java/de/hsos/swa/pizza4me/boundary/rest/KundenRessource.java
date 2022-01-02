package de.hsos.swa.pizza4me.boundary.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.boundary.dto.KundeDTO;
import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.entity.Kunde;

@Path("/kunde")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional(value = TxType.REQUIRES_NEW)
@RequestScoped
public class KundenRessource {

    @Inject
    @Named("KundenRepo")
    KundenService kundenService;

    @GET
    public Response alleKundenAnzeigen() {

        List<Kunde> kunden = kundenService.alleKundenAnzeigen();
        if (kunden.isEmpty()) {
            return Response.noContent().build();
        }
        List<KundeDTO> kundenDTOs = new ArrayList<>();
        for (Kunde k : kunden) {
            kundenDTOs.add(KundeDTO.Converter.toKundeDTO(k));
        }

        return Response.ok(kundenDTOs).build();

    }

    @GET
    @Path("/{id}")
    public Response kundeAnzeigen(@PathParam int id) {
        Kunde kunde = kundenService.kundeAnzeigen(id);
        KundeDTO kundeDTO = KundeDTO.Converter.toKundeDTO(kunde);
        return Response.ok(kundeDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response kundeLoeschen(@PathParam int id) {
        kundenService.kundeLoeschen(id);
        return Response.ok().build();
    }

    @POST
    public Response kundeHinzufuegen(String name) {
        Kunde kundeRet;
        kundeRet = kundenService.kundeHinzufuegen(name);
        return Response.ok().entity(KundeDTO.Converter.toKundeDTO(kundeRet)).build();
    }

    @PUT
    public Response kundeAendern(KundeDTO kundeDTO) {
        int id = kundeDTO.id;

        if (id == 0) {
            throw new WebApplicationException("Pizza ID was not set on request.", 422);
        }

        if (kundeDTO.adresse == null) {
            throw new WebApplicationException("Pizza Name was not set on request.", 422);
        }

        Kunde kundeToChange = kundenService.kundeAnzeigen(id);

        if (kundeToChange == null) {
            throw new WebApplicationException("No Pizza with ID: " + id + " found.", 422);
        }

        kundeToChange.setAdresse(KundeDTO.Converter.toKunde(kundeDTO).getAdresse());
        kundeToChange.setBestellungen(KundeDTO.Converter.toKunde(kundeDTO).getBestellungen());

        return Response.ok(KundeDTO.Converter.toKunde(kundeDTO)).build();

    }

}
