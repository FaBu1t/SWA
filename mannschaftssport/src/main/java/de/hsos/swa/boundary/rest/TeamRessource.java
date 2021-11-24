package de.hsos.swa.boundary.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.NullCipher;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import javax.ws.rs.core.Response.Status;

import de.hsos.swa.control.DataBuilder;
import de.hsos.swa.control.DataManager;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.DataObject;

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
    public Response getTeams(@QueryParam("filter[name]") String name,
            @QueryParam("category[category]") String category) {

        if (name == null && category == null) {
            DataObject allTeams = manager.searchAllTeams();
            for (Data d : allTeams.data) {
                d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
            }
            return Response.ok(allTeams).build();
        } else {
            Set<DataObject> responseObject = new HashSet<>();
            if (name != null) {
                String names[] = name.split(",");
                if (names.length > 0) {
                    for (String filterName : names) {
                        DataObject toAdd = manager.searchTeam(filterName);
                        for (Data d : toAdd.data) {
                            d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
                        }
                        responseObject.add(toAdd);

                    }
                } else {

                    DataObject toAdd = manager.searchTeam(name);
                    for (Data d : toAdd.data) {
                        d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
                    }
                    responseObject.add(toAdd);
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
        DataObject dObject = manager.searchTeam(id, null);
        for (Data d : dObject.data) {
            d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
        }
        return Response.ok(dObject).build();
    }

    @GET
    @Path("/{id}/relationship/{relationshipType}")
    public Response getTeamwithRelationship(@PathParam("id") int id, @PathParam("relationshipType") String relType) {
        DataObject responseObject = manager.searchTeam(id, relType);
        for(Data d:responseObject.data){
            d.
        }
        return Response.ok(responseObject).build();
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
