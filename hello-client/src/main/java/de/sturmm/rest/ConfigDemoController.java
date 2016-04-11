package de.sturmm.rest;

import de.sturmm.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@RestController
public class ConfigDemoController {


    @Value("${foo:NOT_FOUND}")
    String foo;

    @RequestMapping("/config")
    public String getFoo() {
        return foo;
    }

}
