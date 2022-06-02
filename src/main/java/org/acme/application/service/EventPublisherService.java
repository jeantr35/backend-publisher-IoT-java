package org.acme.application.service;

import org.acme.application.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class EventPublisherService {

    @Inject
    Publisher publisher;

    public Response execute(){
        publisher.publishMessage("From service");
        return Response.ok().build();
    }

}
