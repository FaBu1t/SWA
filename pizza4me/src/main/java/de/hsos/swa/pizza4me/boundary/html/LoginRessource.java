package de.hsos.swa.pizza4me.boundary.html;

import javax.ws.rs.GET;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginRessource {
    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance login();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response login() {
        return Response.ok(Templates.login()).build();
    }
}
