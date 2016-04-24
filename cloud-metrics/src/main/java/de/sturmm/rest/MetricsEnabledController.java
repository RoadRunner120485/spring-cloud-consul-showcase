package de.sturmm.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MetricsEnabledController {

    final GaugeService gaugeService;
    final CounterService counterService;


    @RequestMapping("/hello-metrics")
    public String index() {
        counterService.increment("metrics-request");
        return "Greetings from Spring Boot!";
    }

}