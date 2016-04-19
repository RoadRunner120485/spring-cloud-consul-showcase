package de.sturmm.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.cloud.bus.jackson.SubtypeModule;
import org.springframework.cloud.consul.bus.EventService;
import org.springframework.cloud.consul.bus.SimpleRemoteEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@RestController
public class EventDemoController {

    @Inject
    @Qualifier("cloudBusOutboundChannel")
    private MessageChannel cloudBusOutboundChannel;

    @RequestMapping("/event")
    public void fireEvent() {
        cloudBusOutboundChannel.send(MessageBuilder.withPayload(createEvent()).build());
    }

    private SimpleRemoteEvent createEvent() {
        return new SimpleRemoteEvent(this, "helloClient", "helloService", "Hello Event");
    }

}
