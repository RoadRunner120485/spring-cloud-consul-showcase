package de.sturmm.rest;

import de.sturmm.stream.HelloOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sturmm on 10.04.16.
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloController {

    private final HelloOut helloWorld;

    @RequestMapping("/hello")
    public void index(@RequestParam(name = "name") String name) {
        log.info(String.format("Publishing '%s'", name));
        helloWorld.hello().send(MessageBuilder.withPayload(name).build());
    }

}
