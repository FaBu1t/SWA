package de.hsos.swa.boundary.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsos.swa.control.DataManager;

@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamRessource {

    @Inject
    DataManager manager;

    @GET
    public Response getTeams(@QueryParam("filter[name]") String name) {
        if (name == null) {
            return Response.ok(manager.searchAllTeams()).build();
        } else {
            return Response.ok(manager.searchTeam(name)).build();
        }

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

}
