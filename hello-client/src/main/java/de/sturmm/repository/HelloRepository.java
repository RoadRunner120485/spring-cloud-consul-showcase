package de.sturmm.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class HelloRepository {

    private static final String HELLO_SERVICE = "/hello";

    final LoadBalancerClient client;
    RestOperations restOperations = new RestTemplate();

    public String getHelloWorld() {
        final ServiceInstance service = client.choose("helloService");
        return restOperations.getForObject(service.getUri().toString() + HELLO_SERVICE, String.class);
    }

}
