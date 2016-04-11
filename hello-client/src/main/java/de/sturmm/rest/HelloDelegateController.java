package de.sturmm.rest;

import de.sturmm.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class HelloDelegateController {

    final HelloRepository repo;

    @RequestMapping("/hello")
    public String index() {
        return repo.getHelloWorld();
    }

}
