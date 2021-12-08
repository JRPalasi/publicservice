package com.adidas.publicservice.client;

import com.adidas.publicservice.dto.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "email", url = "http://localhost:8082", configuration = EmailClientConfiguration.class
)
public interface EmailClient {

    @PostMapping("/cancel")
    public boolean cancellation(@RequestBody Email email);

    @PostMapping("/create")
    public boolean creation(@RequestBody Email email);
}
