package de.sturmm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String index(ServletRequest request) {
        log.info("hello resource requested.");
        return "Greetings from Spring Boot! -> " + request.getServerName() + ":" + request.getServerPort();
    }

}