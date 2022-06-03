package org.acme.infrastructure.controller;

import io.smallrye.mutiny.Uni;
import org.acme.application.service.EventPublisherService;
import org.acme.application.command.UpdateStateCommand;
import org.acme.domain.model.Gadget;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/states")
public class StateUpdateController {

    @Inject
    EventPublisherService eventPublisherService;

    @Path("/updateState")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Gadget> updateState(UpdateStateCommand updateStateCommand) {
        return eventPublisherService.execute(updateStateCommand);
    }

}