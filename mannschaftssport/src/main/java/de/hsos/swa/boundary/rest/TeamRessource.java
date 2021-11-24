package de.hsos.swa.boundary.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hsos.swa.control.DataManager;
import de.hsos.swa.entity.DTOs.DataObject;

@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamRessource {

    @Inject
    DataManager manager;

    @GET
    public Response getTeams(@QueryParam("filter[name]") String name,
            @QueryParam("category[category]") String category) {

        if (name == null && category == null) {
            return Response.ok(manager.searchAllTeams()).build();
        } else {
            Set<DataObject> responseObject = new HashSet<>();
            if (name != null) {
                String names[] = name.split(",");
                if (names.length > 0) {
                    for (String filterName : names) {
                        responseObject.add(manager.searchTeam(filterName));
                    }
                } else {
                    responseObject.add(manager.searchTeam(name));
                }
            }
            if (category != null) {
                String categories[] = category.split(",");
                if (categories.length > 0) {
                    for (String filterCategory : categories) {
                        responseObject.add(manager.searchTeamByCategory(filterCategory));
                    }
                } else {
                    responseObject.add(manager.searchTeamByCategory(category));
                }
            }
            return Response.ok(responseObject).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getTeam(@PathParam("id") int id) {
        return Response.ok(manager.searchTeam(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") int id) {
        if (manager.deletePerson(id)) {
            return Response.ok().build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    /*
     * @GET
     * 
     * @Path("/{name}") public Response getTeam(@PathParam("name") String name) {
     * return Response.ok(manager.searchTeam(name)).build(); }
     */

}
