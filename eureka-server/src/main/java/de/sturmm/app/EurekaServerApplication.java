package de.sturmm.app;

import de.sturmm.config.EurekaServerConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sturmm on 22.04.16.
 */
@SpringBootApplication
public class EurekaServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaServerConfiguration.class);
    }

    public static void main(String[] args) {
        new EurekaServerApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }

}
