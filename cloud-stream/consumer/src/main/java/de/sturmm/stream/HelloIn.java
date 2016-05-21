package de.sturmm.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by sturmm on 21.05.16.
 */
public interface HelloIn {

    @Input("helloChannel")
    SubscribableChannel hello();

}
