package com.adidas.publicservice.client;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Configuration class to set the basic auth params for the client for email service.
 */
public class EmailClientConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("adidas", "hiremenow");
    }
}
