package de.sturmm.app;

import de.sturmm.config.MetricsConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sturmm on 22.04.16.
 */
public class MetricsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MetricsConfiguration.class);
    }

    public static void main(String[] args) {
        new MetricsApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }

}
