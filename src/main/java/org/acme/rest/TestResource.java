package org.acme.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/health")
public class TestResource {

    @GET
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> isServiceAlive() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("result", "server is alive");
        return resultMap;
    }
}