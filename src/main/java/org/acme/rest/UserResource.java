package org.acme.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/users")
public class UserResource {

    @GET
    @Path("/{me}")
    @Produces(MediaType.TEXT_PLAIN)
    public String currentUser( @Context SecurityContext securityContext) {
        return "logged in username" + (String.valueOf(securityContext.getUserPrincipal() != null?
                securityContext.getUserPrincipal().getName(): ""));
    }
}
