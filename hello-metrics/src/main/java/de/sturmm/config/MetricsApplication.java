package de.sturmm.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilter;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = "de.sturmm")
public class MetricsApplication {

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

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MetricsApplication.class, args);
    }

//    @Bean
//    public ConsoleReporter test(MetricRegistry registry) {
//        final ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .build();
//        reporter.start(5, TimeUnit.SECONDS);
//
//        return reporter;
//    }

}
