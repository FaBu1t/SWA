package de.hsos.swa.shared;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;

import de.hsos.swa.boundary.rest.TeamRessource;
import de.hsos.swa.entity.Team;

@ApplicationScoped
public class UriBuilder {

    public URI forTeam(int id, UriInfo uriInfo) {
        return createResourceUri(TeamRessource.class, "getTeam", id, uriInfo);
    }

    private URI createResourceUri(Class<?> resourceClass, String method, int id, UriInfo uriInfo) {
        System.out.println("Class: " + resourceClass + " Method: " + method + " id: " + id + " uriinfo: " + uriInfo);
        URI uri = uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method).build(id);
        if (uri == null) {
            System.out.println("uri null");
        }
        return uri;
    }

}
