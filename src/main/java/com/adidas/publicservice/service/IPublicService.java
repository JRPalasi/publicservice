package com.adidas.publicservice.service;

import com.adidas.publicservice.dto.Subscription;

import java.util.List;

/**
 * Interface for subscriptions service operations
 */
public interface IPublicService {

    /**
     * Creates a new subscription in the system and notifies the subscription owner
     * @param subscription Subscription DTO with the data for the system
     * @return Created Subscription in the system
     */
    Subscription create(Subscription subscription);

    /**
     * Deletes the subscription identified by Id from the system  and notifies the subscription owner
     * @param id Identifier of the subscription.
     * @return true if cancelled
     */
    boolean cancel(long id);

    /**
     * Lists all the subscriptions in the system
     * @return List of Subscriptions in the system
     */
    List<Subscription> list();

    /**
     * Retrieves the subscription identified by the parameter Id.
     * @param id Identifier of the subscription
     * @return The subscription identified*
     */
    Subscription get(long id);
}
