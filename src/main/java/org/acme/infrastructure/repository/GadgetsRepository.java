package org.acme.infrastructure.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import org.acme.domain.model.Gadget;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GadgetsRepository implements ReactivePanacheMongoRepository<Gadget> {

    public Uni<List<Gadget>> findByDeviceId(String deviceId){
        return list("deviceId", deviceId);
    }

    public Uni<Gadget> findByDeviceIdAndName(String deviceId, String name){
        return find("deviceId = ?1 and name = ?2", deviceId, name).firstResult();
    }

}
