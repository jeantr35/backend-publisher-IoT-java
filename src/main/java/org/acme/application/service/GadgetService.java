package org.acme.application.service;

import io.smallrye.mutiny.Uni;
import org.acme.domain.model.Gadget;
import org.acme.infrastructure.repository.GadgetsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GadgetService {

    @Inject
    private GadgetsRepository gadgetsRepository;

    public Uni<Gadget> getGadget(String deviceId, String name) {
        return gadgetsRepository.findByDeviceIdAndName(deviceId, name);
    }

    public Uni<Gadget> createGadget(Gadget gadget) {
        return gadgetsRepository.persist(gadget);
    }

    public Uni<Gadget> updateGadget(String deviceId, String name, Gadget gadget) {
        return gadgetsRepository.findByDeviceIdAndName(deviceId, name).flatMap(oldGadget -> {
            gadgetsRepository.delete(oldGadget);
            return gadgetsRepository.persist(gadget);
        });
    }

    public Uni<Void> deleteGadget(String deviceId, String name) {
        return gadgetsRepository.findByDeviceIdAndName(deviceId, name)
                .flatMap(oldGadget -> gadgetsRepository.delete(oldGadget));
    }

}
