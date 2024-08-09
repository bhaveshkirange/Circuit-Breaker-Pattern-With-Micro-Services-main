/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.config;

import dev.lokeshbisht.CartService.exceptions.CartNotFoundException;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomCircuitBreakerConfig {

    @Bean
    public CircuitBreakerConfigCustomizer catalogCircuitBreaker() {
        return CircuitBreakerConfigCustomizer
            .of("catalogServiceBreaker",
                builder -> builder
                    .ignoreExceptions(CartNotFoundException.class));
    }
}
