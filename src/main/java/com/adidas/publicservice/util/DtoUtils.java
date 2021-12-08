package com.adidas.publicservice.util;

import com.adidas.publicservice.dto.Email;
import com.adidas.publicservice.dto.Subscription;

/**
 * Utility class for DTOs
 */
public class DtoUtils {

    private DtoUtils() {
        throw new IllegalStateException( "Utility class for static use");
    }

    /**
     * Creates an Email DTO from the subscription data
     * @param subscription Subscription DTO for reading the data
     * @return Email with data extracted from subscription
     */
    public static Email createEmailFromSubscription(Subscription subscription) {
        Email email = new Email();
        email.setTo(subscription.getEmail());
        email.setName(subscription.getName());
        return email;
    }

}
