package io.ngshop.springcloudapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RouteConfig {
    @Bean
    public RouteLocator gateway(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                        .route(route -> route.path("/Catalog/**")
                                .uri("http://localhost:8080"))
                        .route(route -> route.path("/Basket/**")
                                .uri("http://localhost:8085"))
                        .route(route -> route.path("/api/Order/**")
                                .uri("http://localhost:9003"))
                .build();
    }

}
