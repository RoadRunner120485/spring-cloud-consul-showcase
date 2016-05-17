package de.sturmm.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Created by sturmm on 10.04.16.
 */
@FeignClient("cloud-service")
public interface HelloRepository {

    @RequestMapping("/hello")
    String getHelloWorld();

}
