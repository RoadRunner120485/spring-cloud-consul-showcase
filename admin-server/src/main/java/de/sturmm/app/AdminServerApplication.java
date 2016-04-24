package de.sturmm.app;

import de.sturmm.config.AdminServerConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by sturmm on 22.04.16.
 */
public class AdminServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AdminServerConfiguration.class);
    }

    public static void main(String[] args) {
        new AdminServerApplication().configure(new SpringApplicationBuilder()).build().run(args);
    }

}
