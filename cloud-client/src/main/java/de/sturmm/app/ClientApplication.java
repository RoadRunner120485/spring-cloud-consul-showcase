package de.sturmm.app;

import de.sturmm.config.ClientConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Created by sturmm on 20.04.16.
 */
@SpringBootApplication
@Import(ClientConfiguration.class)
public class ClientApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ClientApplication.class);
    }

    public static void main(String[] args) {
        new ClientApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }
}
