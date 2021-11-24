package de.hsos.swa.boundary.rest;

import java.net.URI;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Link;

import de.hsos.swa.control.DataManager;
import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.DataObject;
import de.hsos.swa.shared.UriBuilder;

@ApplicationScoped
@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamRessource {

    @Inject
    DataManager manager;

    @Inject
    UriBuilder uriBuilder;

    @Context
    UriInfo uriInfo;

    @GET
    public Response getTeams(@QueryParam("filter[name]") String name) {
        System.out.println(uriInfo);

        DataObject dataObj;
        if (name == null) {
            dataObj = manager.searchAllTeams();

        } else {
            dataObj = manager.searchTeam(name);
        }
        for (Data d : dataObj.data) {
            URI link = this.buildSelfLinkforTeam(d.id);
            d.addLinks("self", link);
        }

        return Response.ok(dataObj).build();

    }

    @GET
    @Path("/{id}")
    public Response getTeam(@PathParam("id") int id) {
        return Response.ok(manager.searchTeam(id)).build();
    }

    /*
     * @GET
     * 
     * @Path("/{name}") public Response getTeam(@PathParam("name") String name) {
     * return Response.ok(manager.searchTeam(name)).build(); }
     */

    private URI buildSelfLinkforTeam(int id) {

        URI uri = uriBuilder.forTeam(id, this.uriInfo);
        Link linkToTeam = Link.fromUri(uri).build();

        return uri;
    }
}
