package io.ngshop.springcloudapigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Configuration
@Slf4j
public class RouteConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/Basket/**")
                        .filters(f -> f.filter((exchange, chain) -> {
                            var header = exchange.getRequest().getHeaders()
                                    .get("Custom-Header");
                            log.info("Headers: {}", header);
                            return chain.filter(exchange);
                        }))
                        .uri("http://localhost:8081"))
                .route(r -> r.path("/Catalog/**")
//                        .filters(f -> f.filter(new GatewayFilter() {
//                            @Override
//                            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                                exchange.getRequest()
//                                return null;
//                            }
//                        }))
                        .uri("localhost:8085"))
                //localhost:8089/Basket/feign -> localhost:8081/Basket/feign
                .build();
    }
}
