package de.hsos.swa.pizza4me.boundary.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.pizza4me.control.KundenService;

@Path("/kunde")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KundenRessource {

    @Inject 
    @Named("KundenRepo")
    KundenService kundenService;


    @GET
    public Response alleKundenAnzeigen(){



        return Response.noContent().build();
        
    }
    
}
