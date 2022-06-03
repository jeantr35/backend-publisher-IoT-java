package org.acme.infrastructure.controller;

import io.smallrye.mutiny.Uni;
import org.acme.application.service.GadgetService;
import org.acme.domain.model.Gadget;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/gadget")
public class GadgetController {

    @Inject
    private GadgetService gadgetService;

    @Path("/{deviceId}/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Gadget> getGadget(String deviceId, String name) {
        return gadgetService.getGadget(deviceId, name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Gadget> createGadget(Gadget gadget) {
        return gadgetService.createGadget(gadget);
    }

    @Path("/{deviceId}/{name}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Gadget> updateGadget(String deviceId, String name, Gadget gadget) {
        return gadgetService.updateGadget(deviceId, name, gadget);
    }

    @Path("/{deviceId}/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Void> deleteGadget(String deviceId, String name) {
        return gadgetService.deleteGadget(deviceId, name);
    }

}
