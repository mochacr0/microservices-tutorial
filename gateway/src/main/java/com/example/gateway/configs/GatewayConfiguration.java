package com.example.gateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfiguration {

//    @Bean
    public RouteLocator buildRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("user-service",
                        r -> r.path("/users/**")
                                .uri("http://localhost:8081"))
                .route("common-service",
                        r -> r.path("/common/**")
                                .uri("http://localhost:8082"))
                .build();
    }
}
