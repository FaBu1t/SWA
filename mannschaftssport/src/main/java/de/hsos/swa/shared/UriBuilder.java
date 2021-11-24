package de.hsos.swa.shared;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;

import de.hsos.swa.boundary.rest.TeamRessource;

@ApplicationScoped
public class UriBuilder {

    public URI forTeam(int id, UriInfo uriInfo) {
        return createResourceUri(TeamRessource.class, "getTeam", id, uriInfo);
    }

    public URI forRelationship(int id, String relType, UriInfo uriInfo, String method) {
        return createResourceUriRelationship(TeamRessource.class, method, id, relType, uriInfo);
    }

    private URI createResourceUriRelationship(Class<?> resourceClass, String method, int id, String relType,
            UriInfo uriInfo) {
        System.out.println("Class: " + resourceClass + " Method: " + method + " id: " + id + " uriinfo: "
                + uriInfo.getRequestUri());
        URI uri = uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method).build(id, relType);
        System.out.println(uri);
        if (uri == null) {
            System.out.println("uri null");
        }
        return uri;
    }

    private URI createResourceUri(Class<?> resourceClass, String method, int id, UriInfo uriInfo) {
        System.out.println("Class: " + resourceClass + " Method: " + method + " id: " + id + " uriinfo: "
                + uriInfo.getRequestUri());
        URI uri = uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method).build(id);
        if (uri == null) {
            System.out.println("uri null");
        }
        return uri;
    }

}
