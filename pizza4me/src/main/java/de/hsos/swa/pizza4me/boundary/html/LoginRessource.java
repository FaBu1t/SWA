package de.hsos.swa.pizza4me.boundary.html;

import java.security.Principal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PostPersist;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.entity.Kunde;
import de.hsos.swa.pizza4me.entity.Security.UserLogin;

@Path("/login")
public class LoginRessource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance login_login();

        public static native TemplateInstance login_register();
    }

    @Inject
    @Named("KundenRepo")
    KundenService kundenService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response login() {
        return Response.ok(Templates.login_register()).build();

    }

    @GET
    @Path("/register")
    @Produces(MediaType.TEXT_HTML)
    public Response register() {
        return Response.ok(Templates.login_register()).build();
    }

    @POST
    @Path("/register/send")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addUser(@FormParam("username") String username, @FormParam("password") String passwort) {
        UserLogin.add(username, passwort, "KundIn");
        Kunde kunde = kundenService.kundeHinzufuegen(username);
        return Response.seeOther(UriBuilder.fromPath("/index/kunde/").build()).build();
    }

}
