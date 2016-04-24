package de.sturmm.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilter;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;
import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.ConsulLifecycle;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = "de.sturmm")
public class MetricsConfiguration {

    @Bean
    public FilterRegistrationBean metricsFilter() {
        final InstrumentedFilter instrumentedFilter = new InstrumentedFilter();
        final FilterRegistrationBean fiReB = new FilterRegistrationBean(instrumentedFilter);
        fiReB.addInitParameter("name-prefix", "test");

        return fiReB;
    }

    @Bean
    public InstrumentedFilterContextListener contextListener(final MetricRegistry metricRegistry) {
        return new InstrumentedFilterContextListener() {
            @Override
            protected MetricRegistry getMetricRegistry() {
                return metricRegistry;
            }
        };
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
