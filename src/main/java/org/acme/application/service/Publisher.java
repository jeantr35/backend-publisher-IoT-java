package org.acme.application.service;

import org.acme.application.command.UpdateStateCommand;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Publisher {

    int qos             = 2;
    String broker       = "tcp://192.168.1.11:1883";
    String clientId     = "BackendJava";

    public void publishMessage(UpdateStateCommand updateStateCommand){
    MemoryPersistence persistence = new MemoryPersistence();
        try {
        MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        sampleClient.connect(connOpts);
        MqttMessage message = new MqttMessage(updateStateCommand.getState().getBytes());
        message.setQos(qos);
        sampleClient.publish(updateStateCommand.getUuid()+"/"+updateStateCommand.getName(), message);
        sampleClient.disconnect();
    } catch(MqttException me) {
        System.out.println("reason "+me.getReasonCode());
        System.out.println("msg "+me.getMessage());
        System.out.println("loc "+me.getLocalizedMessage());
        System.out.println("cause "+me.getCause());
        System.out.println("excep "+me);
        me.printStackTrace();
    }
}

}
