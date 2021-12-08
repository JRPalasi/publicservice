package com.adidas.publicservice.service.impl;

import com.adidas.publicservice.client.EmailClient;
import com.adidas.publicservice.client.SubscriptionClient;
import com.adidas.publicservice.dto.Email;
import com.adidas.publicservice.dto.Subscription;
import com.adidas.publicservice.service.IPublicService;
import com.adidas.publicservice.util.DtoUtils;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * Implementation of PublicService for subscription system
 */
@Service
public class PublicService implements IPublicService {

    /**
     * Subscription service client
     */
    @Autowired
    private SubscriptionClient subscriptionClient;

    /**
     * Email service client
     */
    @Autowired
    private EmailClient emailClient;

    /**
     * Creates a new subscription in the system and notifies the subscription owner
     * @param subscription Subscription DTO with the data for the system
     * @return Created Subscription in the system
     */
    @Override
    public Subscription create(Subscription subscription) {
        Subscription created;
        try {
            Long subscriptionId = subscriptionClient.create(subscription);
            created = get(subscriptionId);
            Email email = DtoUtils.createEmailFromSubscription(subscription);
            emailClient.creation(email);
        } catch (FeignException e) {
            if (e.status() == 400) {
                created = null;
            } else {
                throw e;
            }
        }

        return created;
    }

    /**
     * Deletes the subscription identified by Id from the system  and notifies the subscription owner
     * @param id Identifier of the subscription.
     * @return true if cancelled
     */
    @Override
    public boolean cancel(long id) {
        boolean cancelled = false;
        Subscription subscription = get(id);
        if (subscription != null) {
            ResponseEntity<?> response = subscriptionClient.cancel(id);
            if (response.getStatusCode() == OK) {
                Email email = DtoUtils.createEmailFromSubscription(subscription);
                emailClient.cancellation(email);
                cancelled = true;
            }
        }

        return cancelled;
    }

    /**
     * Lists all the subscriptions in the system
     * @return List of Subscriptions in the system
     */
    @Override
    public List<Subscription> list() {
        List<Subscription> result;
        try {
            result = subscriptionClient.list();
        } catch (FeignException e) {
            if (e.status() == 404) {
                result = Collections.emptyList();
            } else {
                throw e;
            }
        }
        return result;
    }

    /**
     * Retrieves the subscription identified by the parameter Id.
     * @param id Identifier of the subscription
     * @return The subscription identified*
     */
    @Override
    public Subscription get(long id) {
        Subscription result;
        try {
            result = subscriptionClient.get(id);
        } catch (FeignException e) {
            if (e.status() == 404) {
                result = null;
            } else {
                throw e;
            }
        }

        return result;
    }
}
