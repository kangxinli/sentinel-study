package com.sample.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>A demo for Spring Cloud Gateway.</p>
 *
 * <p>To integrate with Sentinel dashboard, you can run the demo with the parameters (an example):
 * <code>-Dproject.name=spring-cloud-gateway -Dcsp.sentinel.dashboard.server=localhost:8080
 * -Dcsp.sentinel.api.port=8720 -Dcsp.sentinel.app.type=1
 * </code>
 * </p>
 *
 */
@SpringBootApplication
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class, args);
    }
}
