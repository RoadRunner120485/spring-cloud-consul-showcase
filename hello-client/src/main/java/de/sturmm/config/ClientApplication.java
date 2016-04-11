package de.sturmm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.SubtypeModule;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.bus.SimpleRemoteEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.config.EnableIntegration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableIntegration
@ComponentScan(basePackages = "de.sturmm")
public class ClientApplication {

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void setupObjectMapper(){
        objectMapper.registerSubtypes(SimpleRemoteEvent.class);
            objectMapper.registerModule(new SubtypeModule(SimpleRemoteEvent.class));
    }

    public static void main(String[] args) {
        final ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);
    }

}
