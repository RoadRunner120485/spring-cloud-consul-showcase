package de.sturmm.config;

import de.sturmm.stream.HelloIn;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({HelloIn.class})
@ComponentScan(basePackages = "de.sturmm")
public class StreamConfiguration {

}
