package com.adidas.publicservice;

import com.adidas.publicservice.dto.Subscription;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PublicServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private TestRestTemplate getRestTemplate() {
        return restTemplate.withBasicAuth("adidas", "4d1d4$");
    }

    private ResponseEntity getSubscriptionResponse() {
        return getRestTemplate().getForEntity("http://localhost:" + port + "/subscriptions", Subscription[].class);
    }

    @Test
    void testList() {
        ResponseEntity<Subscription[]> response = getSubscriptionResponse();
        Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.OK);
        Assertions.assertThat(response.getBody().length > 0).isTrue();
    }

    @Test
    void testGet() {
        ResponseEntity<Subscription> response = getRestTemplate().getForEntity("http://localhost:" + port + "/subscriptions/1", Subscription.class);
        Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }

//    @Test
    void testCreation() {
        ResponseEntity<Subscription[]> subscriptionResponse = getSubscriptionResponse();
        int numberOfSubscriptions = subscriptionResponse.getBody().length;

        Subscription subscription = new Subscription("Antonio", "antonio@adidas.com", Subscription.Gender.MALE, LocalDate.of(1987, 3, 23), true, 1L);
        Long id = getRestTemplate().postForObject("http://localhost:" + port + "/subscriptions", subscription, Long.class);
        Assertions.assertThat( id ).isNotNull().isPositive();

        subscriptionResponse = getSubscriptionResponse();
        Assertions.assertThat(subscriptionResponse.getBody().length).isSameAs(numberOfSubscriptions + 1);
    }

    @Test
    void testCancel() {
        ResponseEntity<Subscription[]> subscriptionResponse = getSubscriptionResponse();
        int numberOfSubscriptions = subscriptionResponse.getBody().length;

        getRestTemplate().delete("http://localhost:" + port + "/subscriptions/1");

        subscriptionResponse = getSubscriptionResponse();
        Assertions.assertThat(subscriptionResponse.getBody()).hasSize(numberOfSubscriptions - 1);
    }

//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    void testList() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subscriptions").contentType(MediaType.APPLICATION_JSON);
//        mvc.perform(requestBuilder).andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", Matchers.hasSize(4)));
//
//    }
}
