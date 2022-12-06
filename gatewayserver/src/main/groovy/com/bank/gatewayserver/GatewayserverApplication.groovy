package com.bank.gatewayserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableEurekaClient
class GatewayserverApplication {

    static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication, args)
    }

    /**
     * Spring cloud gateway customer routing bean
     * @param builder
     * @return
     */
    @Bean
    RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/xonixbanks/accounts/**")
                        .filters(f -> f.rewritePath("/xonixbanks/accounts/(?<segment>.*)", "/\${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://ACCOUNTS")
                )
                .route(p -> p.path("/xonixbanks/cards/**")
                        .filters(f -> f.rewritePath("/xonixbanks/cards/(?<segment>.*)", "/\${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://CARDS")
                )
                .route(p -> p.path("/xonixbanks/loans/**")
                        .filters(f -> f.rewritePath("/xonixbanks/loans/(?<segment>.*)", "/\${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://LOANS")
                ).build()
    }

}
