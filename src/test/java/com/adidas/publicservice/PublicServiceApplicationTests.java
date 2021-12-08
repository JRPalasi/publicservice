package com.adidas.publicservice;

import com.adidas.publicservice.controller.ServiceController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublicServiceApplicationTests {

    @Autowired
    private ServiceController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat( controller ).isNotNull();
    }

}
