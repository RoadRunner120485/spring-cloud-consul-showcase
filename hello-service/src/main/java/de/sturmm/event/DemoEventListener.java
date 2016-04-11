package de.sturmm.event;

import org.springframework.cloud.consul.bus.SimpleRemoteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by sturmm on 10.04.16.
 */
@MessageEndpoint
public class DemoEventListener implements ApplicationListener<SimpleRemoteEvent> {
    @Override
    public void onApplicationEvent(SimpleRemoteEvent event) {
        System.out.println(event.getSource());
    }

    @ServiceActivator(inputChannel = "cloudBusInboundChannel")
    public void doit(SimpleRemoteEvent msg) {
        System.out.println(msg.getMessage());
    }
}
