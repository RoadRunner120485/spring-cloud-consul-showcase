package de.sturmm.debug;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.stream.SleuthSink;
import org.springframework.cloud.sleuth.stream.Spans;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by sturmm on 21.05.16.
 */
@Component
@Slf4j
public class HelloListener {

    @StreamListener("helloChannel")
    public void handle(String name) {
        log.info(String.format("Hello '%s'", name));
    }

}
