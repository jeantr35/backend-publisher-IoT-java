package org.acme.application.service;

import io.smallrye.mutiny.Uni;
import org.acme.application.command.UpdateStateCommand;
import org.acme.domain.model.Gadget;
import org.acme.infrastructure.repository.GadgetsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class EventPublisherService {

    @Inject
    private GadgetsRepository gadgetsRepository;

    @Inject
    private Publisher publisher;

    public Uni<Gadget> execute(UpdateStateCommand updateStateCommand){
        return gadgetsRepository.findByDeviceIdAndName(updateStateCommand.getUuid(), updateStateCommand.getName())
                .flatMap(gadget -> {
                    gadget.setState(updateStateCommand.getState());
                    publisher.publishMessage(updateStateCommand);
                    return gadgetsRepository.update(gadget);
                });
    }

}
