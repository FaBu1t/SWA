package de.hsos.swa.boundary.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import de.hsos.swa.control.DataManager;
import de.hsos.swa.entity.DTOs.TeamDTO;

@Path("/teams")
public class TeamRessource {

    @Inject
    DataManager manager;

    @GET
    public Response getTeams() {

        return Response.noContent().build();

    }

}
