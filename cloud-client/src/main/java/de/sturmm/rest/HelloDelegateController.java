package de.sturmm.rest;

import de.sturmm.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class HelloDelegateController {

    final HelloRepository repo;

    @RequestMapping("/hello")
    public String index() {
        log.info("Fetching hello-resource.");
        return repo.getHelloWorld();
    }

}
