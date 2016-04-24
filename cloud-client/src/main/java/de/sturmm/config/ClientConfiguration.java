package de.sturmm.config;

import com.ecwid.consul.v1.ConsulClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.bus.jackson.SubtypeModule;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.bus.SimpleRemoteEvent;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulLifecycle;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.config.EnableIntegration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableIntegration
@ComponentScan(basePackages = "de.sturmm")
public class ClientConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void setupObjectMapper(){
        objectMapper.registerSubtypes(SimpleRemoteEvent.class);
            objectMapper.registerModule(new SubtypeModule(SimpleRemoteEvent.class));
    }

    @Autowired
    private ConsulClient consulClient;

    @Bean
    @Profile("docker")
    public ConsulLifecycle consulLifecycle(ServerProperties serverProperties,
                                           ConsulDiscoveryProperties discoveryProperties,
                                           HeartbeatProperties heartbeatProperties) {
        return new ContainerConsulLifeCycle(serverProperties, consulClient, discoveryProperties, heartbeatProperties);
    }

}
