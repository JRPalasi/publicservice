package com.adidas.publicservice.client;

import com.adidas.publicservice.dto.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feign client for the subscriptions service
 */
@FeignClient(value = "subscriptions", url = "http://localhost:8081", configuration = SubscriptionClientConfiguration.class)
public interface SubscriptionClient {

    @PutMapping("/subscriptions")
    Long create(Subscription subscription);

    @DeleteMapping("/subscriptions/{id}")
    ResponseEntity<?> cancel(@PathVariable Long id);

    @GetMapping("/subscriptions")
    List<Subscription> list();

    @GetMapping("/subscriptions/{id}")
    Subscription get(@PathVariable Long id);
}
