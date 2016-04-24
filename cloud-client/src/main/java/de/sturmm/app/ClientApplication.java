package de.sturmm.app;

import de.sturmm.config.ClientConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sturmm on 20.04.16.
 */
public class ClientApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ClientConfiguration.class);
    }

    public static void main(String[] args) {
        new ClientApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }
}
