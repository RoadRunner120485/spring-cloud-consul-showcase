package de.sturmm.app;

import de.sturmm.config.ServiceConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Created by sturmm on 22.04.16.
 */
@SpringBootApplication
@Import(ServiceConfiguration.class)
public class ServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServiceApplication.class);
    }

    public static void main(String[] args) {
        new ServiceApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }

}
