package com.adidas.publicservice.util;

import com.adidas.publicservice.dto.Email;
import com.adidas.publicservice.dto.Subscription;

public class DtoUtils {

    public static Email createEmailFromSubscription(Subscription subscription) {
        Email email = new Email();
        email.setTo(subscription.getEmail());
        email.setName(subscription.getName());
        return email;
    }

}
