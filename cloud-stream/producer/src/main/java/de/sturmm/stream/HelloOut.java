package de.sturmm.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by sturmm on 21.05.16.
 */
public interface HelloOut {

    @Output("helloChannel")
    MessageChannel hello();

}
