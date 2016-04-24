package de.sturmm.config;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulLifecycle;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.context.event.EventListener;

/**
 * Created by sturmm on 24.04.16.
 */
class ContainerConsulLifeCycle extends ConsulLifecycle {

    private final ServerProperties serverProperties;
    private boolean initialized = false;

    ContainerConsulLifeCycle(ServerProperties serverProperties,
                             ConsulClient client,
                             ConsulDiscoveryProperties properties,
                             HeartbeatProperties ttlConfig) {
        super(client, properties, ttlConfig);
        this.serverProperties = serverProperties;
    }

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        if (!initialized) {
            super.onApplicationEvent(event);
            this.initialized = true;
        }
    }

    @EventListener
    public void onApplicationEvent(@SuppressWarnings("UnusedParameters") ApplicationPreparedEvent event) {
        if (!initialized) {
            if (serverProperties.getPort() > 0) {
                this.setConfiguredPort(serverProperties.getPort());
            }
            this.start();
            this.initialized = true;
        }
    }


}
