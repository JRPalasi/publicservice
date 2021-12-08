package com.adidas.publicservice.client;

import com.adidas.publicservice.dto.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client for the email service
 */
@FeignClient(value = "email", url = "http://localhost:8082", configuration = EmailClientConfiguration.class)
public interface EmailClient {

    @DeleteMapping("/cancel")
    void cancellation(@RequestBody Email email);

    @PostMapping("/create")
    void creation(@RequestBody Email email);
}
