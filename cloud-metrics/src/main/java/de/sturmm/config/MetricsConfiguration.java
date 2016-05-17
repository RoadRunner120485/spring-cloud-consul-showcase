package de.sturmm.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilter;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
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

}
