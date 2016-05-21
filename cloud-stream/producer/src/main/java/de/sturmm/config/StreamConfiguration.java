package de.sturmm.config;

import de.sturmm.stream.HelloOut;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({HelloOut.class})
@ComponentScan(basePackages = "de.sturmm")
public class StreamConfiguration {

}
