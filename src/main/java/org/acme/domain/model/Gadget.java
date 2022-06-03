package org.acme.domain.model;

import org.bson.types.ObjectId;

public class Gadget {

    private ObjectId id;
    private String name;
    private String state;
    private String deviceId;

    public Gadget(String name, String state, String deviceId) {
        this.name = name;
        this.state = state;
        this.deviceId = deviceId;
    }

    public Gadget(ObjectId id, String name, String state, String deviceId) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.deviceId = deviceId;
    }

    public Gadget() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
