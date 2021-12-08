package com.adidas.publicservice.client;

import com.adidas.publicservice.dto.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "subscriptions", url = "http://localhost:8081", configuration = SubscriptionClientConfiguration.class)
public interface SubscriptionClient {

    @RequestMapping(value = "/subscriptions", method = RequestMethod.PUT)
    Long create(Subscription subscription);

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> cancel(@PathVariable Long id);

    @RequestMapping(value = "/subscriptions", method = RequestMethod.GET)
    List<Subscription> list();

    @RequestMapping(value = "/subscriptions/{id}", method = RequestMethod.GET)
    Subscription get(@PathVariable Long id);
}
