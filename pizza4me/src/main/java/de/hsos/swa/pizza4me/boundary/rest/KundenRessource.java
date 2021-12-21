package de.hsos.swa.pizza4me.boundary.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
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
    public Response kundeHinzufuegen(KundeDTO kundeDTO) {
        Kunde kunde = KundeDTO.Converter.toKunde(kundeDTO);
        Kunde kundeRet;
        kundeRet = kundenService.kundeHinzufuegen(kunde);
        return Response.ok().entity(KundeDTO.Converter.toKundeDTO(kundeRet)).build();
    }

}
