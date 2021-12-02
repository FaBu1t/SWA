package de.hsos.swa.boundary.rs;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import de.hsos.swa.entity.Kunde;
import de.hsos.swa.control.KundenService;



@Path("/kundenvw")
@Produces("application/json")
@Consumes("application/json")
public class KundenRessource {

    @Inject
    KundenService kundenService;


    @GET
    @Path("/kunden")
    public Response alleKunden(){
       Collection<Kunde> kunden = kundenService.kundenAbfragen();
       if (!kunden.isEmpty()){
           return Response.ok().entity(kunden).build();
       }
        return Response.noContent().build();
    }

    @GET
    @Path("/kunde/{id}")
    public Response sucheKundeNachId(@PathParam Long id){
        Kunde kunde = kundenService.kundeAbfragen(id);
        if (kunde==null){
            return Response.noContent().build();
        }
        return Response.ok().entity(kunde).build();
    }

    @PUT
    @Path("/kunde")
    public Response neuerKunde(String vorname,String nachname){
        this.kundenService.kundenAnlegen(vorname, nachname);
        return Response.ok().build();
    }

    @DELETE
    public Response loescheKunde(long kundennr){
        boolean geloescht=this.kundenService.kundeLoeschen(kundennr);
        if(geloescht){
            return Response.ok().build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }
    


    
}
