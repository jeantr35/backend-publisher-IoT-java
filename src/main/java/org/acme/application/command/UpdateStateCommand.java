package org.acme.application.command;

public class UpdateStateCommand {

    private String uuid;
    private String name;
    private String state;

    public UpdateStateCommand(String uuid, String name, String state) {
        this.uuid = uuid;
        this.name = name;
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}

