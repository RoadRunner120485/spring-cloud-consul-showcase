package de.sturmm.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@ComponentScan(basePackages = "de.sturmm", excludeFilters = {
        @ComponentScan.Filter(Configuration.class)
})
public class ServiceConfiguration {

}
