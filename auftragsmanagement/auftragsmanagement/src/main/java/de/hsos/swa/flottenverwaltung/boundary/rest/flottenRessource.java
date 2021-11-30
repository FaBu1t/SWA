package de.hsos.swa.flottenverwaltung.boundary.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import de.hsos.swa.flottenverwaltung.control.Flottenmanagement;
import de.hsos.swa.flottenverwaltung.entity.Schiff;

@Consumes("application/json")
@Produces("application/json")
@Path("/flottenmanagement")
public class flottenRessource {

    @Inject
    Flottenmanagement flottenManagement;

    @GET
    public Response sucheAlleSchiffe() {
        List<Schiff> schiffe = flottenManagement.sucheAlleSchiffe();

        return Response.ok(schiffe).build();
    }

    @GET
    @Path("/{id}")
    public Response sucheSchiff(@PathParam Long id) {
        Schiff resSchiff = flottenManagement.findById(id);
        if (resSchiff == null) {
            return Response.noContent().build();
        }

        return Response.ok(resSchiff).build();
    }

    @GET
    @Path("/freieschiffe")
    public Response sucheFreieSchiffe() {
        List<Schiff> schiffe = flottenManagement.sucheFreieSchiffe();

        return Response.ok(schiffe).build();
    }

    @POST
    @Path("/{id}")
    public Response setGebucht(@PathParam Long id) {
        flottenManagement.setSchiffGebucht(id);
        return Response.ok().build();
    }

    @PUT
    public void erstelleSchiff(Schiff neuesSchiff) {
        flottenManagement.erstelleSchiff(neuesSchiff);
    }

    @PUT
    public Response erstelleSchiff() {
        Schiff neuesSchiff = new Schiff();
        neuesSchiff.setName("SchiffEins");
        neuesSchiff.setGebucht(false);
        flottenManagement.erstelleSchiff(neuesSchiff);

        return Response.ok().build();
    }

}
