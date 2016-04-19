package de.sturmm.config;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAdminServer
public class AdminServerApplication {


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AdminServerApplication.class, args);
    }

}
