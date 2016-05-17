package de.sturmm.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
