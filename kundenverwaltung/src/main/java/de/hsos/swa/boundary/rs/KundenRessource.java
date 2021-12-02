package de.hsos.swa.boundary.rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.hsos.swa.control.KundenService;



@Path("/kundenvw")
@Produces("application/json")
@Consumes("application/json")
public class KundenRessource {

    @Inject
    KundenService kundenService;

    
}
