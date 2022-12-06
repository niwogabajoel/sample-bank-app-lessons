package com.bank.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

    private static Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    private FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (isCorrelationPresent(requestHeaders)) {
            logger.debug("Xonixbank-Correlation-ID found in trace filter: {}.", filterUtility.getCorrelationId(requestHeaders));
        } else {
            String correlationId = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationId);
            logger.debug("Xonixbank-Correlation-ID generated in trace filter: {}.", correlationId);
        }
        return chain.filter(exchange);
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    private boolean isCorrelationPresent(HttpHeaders requestHeaders) {
        return filterUtility.getCorrelationId(requestHeaders) != null;
    }
}
