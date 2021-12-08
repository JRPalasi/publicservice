package com.adidas.publicservice.controller;

import com.adidas.publicservice.dto.Subscription;
import com.adidas.publicservice.service.IPublicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Public subscription service", description = "Public service for subscription operations")
public class ServiceController {

    @Autowired
    IPublicService service;

    @PutMapping("/subscriptions")
    @Operation(summary = "Creates a new subscription in the subscription system and it notifies the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription created, returns Id of the created subscription"),
            @ApiResponse(responseCode = "400", description = "Could not create subscription")})
    public ResponseEntity<Long> create(@Parameter(required = true, description = "Subscription data information")
                                       @RequestBody Subscription subscription) {
        ResponseEntity response;
        Subscription created = service.create(subscription);
        if (created != null) {
            response = ResponseEntity.ok(created.getId());
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @DeleteMapping("/subscriptions/{id}")
    @Operation(summary = "Cancels a subscription identified by Id in the subscription system and it notifies the user")
    public ResponseEntity cancel(@Parameter(required = true, description = "Id of the subscription to be cancelled")
                                 @PathVariable Long id) {
        ResponseEntity response;
        if (service.cancel(id)) {
            response = ResponseEntity.ok().build();
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("/subscriptions")
    @Operation(summary = "Lists all subscriptions in the subscription system")
    public ResponseEntity<List<Subscription>> list() {
        ResponseEntity response;
        List<Subscription> subscriptions = service.list();
        if (subscriptions.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(subscriptions);
        }
        return response;
    }

    @GetMapping("/subscriptions/{id}")
    @Operation(summary = "Retrieves a subscription in the subscription system identified by Id")
    public ResponseEntity<Subscription> get(@Parameter(required = true, description = "Id of the subscription to be retrieved")
                                            @PathVariable Long id) {
        ResponseEntity response;
        Subscription subscription = service.get(id);
        if (subscription == null) {
            response = ResponseEntity.notFound().build();
        } else {
            response = ResponseEntity.ok(subscription);
        }
        return response;
    }
}
