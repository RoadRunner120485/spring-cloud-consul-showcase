package de.sturmm.app;

import de.sturmm.config.StreamConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Created by sturmm on 21.05.16.
 */
@SpringBootApplication(exclude = {EmbeddedServletContainerAutoConfiguration.class,
        WebMvcAutoConfiguration.class})
@Import(StreamConfiguration.class)
public class StreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }
}
