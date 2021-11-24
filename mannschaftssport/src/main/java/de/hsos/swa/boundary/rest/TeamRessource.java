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
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import de.hsos.swa.entity.DTOs.Included;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
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
    public Response getTeams(@QueryParam("filter[name]") String name, @QueryParam("category[category]") String category,
            @QueryParam("included[included]") String included) {

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
                        DataObject toAdd = manager.searchTeam(filterName, included);
                        for (Data d : toAdd.data) {
                            d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
                        }
                        responseObject.add(toAdd);
                    }
                } else {
                    DataObject toAdd = manager.searchTeam(name, included);
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
            if (included != null) {

                for (DataObject dataObject : responseObject) {
                    Included incl = new Included();
                    for (Data data : dataObject.data) {
                        if (included.equals("manager")) {
                            if (data.relationship.manager != null) {
                                incl.data.add(data.relationship.manager);
                            }

                        } else if (included.equals("players")) {
                            
                        }
                        dataObject.included = incl;
                    }
                }
            }
            return Response.ok(responseObject).build();
        }

    }

    @GET
    @Path("/{id}")
    public Response getTeam(@PathParam("id") int id) {
        DataObject dObject = manager.searchTeam(id, null);
        if (dObject != null) {
            for (Data d : dObject.data) {
                d.addLinks("self", this.uriBuilder.forTeam(d.id, this.uriInfo));
            }
            return Response.ok(dObject).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{id}/relationship/{relationshipType}")
    public Response getTeamwithRelationship(@PathParam("id") int id, @PathParam("relationshipType") String relType) {
        System.out.println(relType);
        DataObject responseObject = manager.searchTeam(id, relType);
        if (relType.equals("manager")) {
            for (Data d : responseObject.data) {
                Data managerToLink = d.getRelationship().manager;
                if (managerToLink != null) {
                    URI selfLink = this.uriBuilder.forRelationship(id, relType, this.uriInfo,
                            "getTeamwithRelationship");
                    URI relatedLink = this.uriBuilder.forRelationship(id, relType, this.uriInfo,
                            "getPersonFromRelationship");
                    managerToLink.addLinks("self", selfLink);
                    managerToLink.addLinks("related", relatedLink);
                }
            }
        } else {
            if (relType.equals("players")) {
                if (responseObject.data.size() == 1) {
                    System.out.println(responseObject.data.get(0));
                    if (responseObject.data.get(0).relationship.players != null) {
                        ArrayList<Data> players = responseObject.data.get(0).relationship.players;

                        for (Data d : players) {
                            if (players != null) {
                                URI relatedLink = this.uriBuilder.forRelationship(id, relType, this.uriInfo,
                                        "getPersonFromRelationship");
                                d.addLinks("related", relatedLink);
                            }
                        }
                        responseObject.data.get(0).relationship.players = players;
                    }

                }
            }
        }
        return Response.ok(responseObject).build();
    }

    @GET
    @Path("/{id}/{relationshipType}")
    public Response getPersonFromRelationship(@PathParam("id") int id, @PathParam("relationshipType") String relType) {
        DataObject responseObj = manager.searchTeam(id, relType);
        Data responseObjTemp = null;
        if (relType.equals("manager")) {
            if (responseObj.data.size() == 1) {
                for (Data d : responseObj.data) {
                    responseObjTemp = d.getRelationship().manager;
                    if (responseObj != null) {
                        URI selfLink = this.uriBuilder.forRelationship(id, relType, this.uriInfo,
                                "getPersonFromRelationship");
                        responseObjTemp.addLinks("self", selfLink);
                    }
                }
            }
            responseObj = new DataObject();
            responseObj.data.add(responseObjTemp);

        } else {
            ArrayList<Data> players = responseObj.data.get(0).relationship.players;
            if (responseObj.data.size() == 1) {
                for (Data d : players) {
                    if (players != null) {
                        URI relatedLink = this.uriBuilder.forRelationship(id, relType, this.uriInfo,
                                "getPersonFromRelationship");
                        d.addLinks("related", relatedLink);
                    }
                }
            }
            responseObj = new DataObject();
            responseObj.data = players;
        }
        return Response.ok(responseObj).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") int id) {
        if (manager.deletePerson(id)) {
            return Response.ok().build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @PUT
    public Response createTeam(TeamDTO team) {
        return Response.ok(manager.createTeam(team)).build();
    }

    @POST
    @Path("/{id}/relationships/manager")
    public Response addRelManager(@PathParam("id") int id, PersonDTO relManager) {
        DataObject responseObject = manager.addManager(id, relManager);

        if (responseObject != null) {
            return Response.ok(responseObject).build();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

}
