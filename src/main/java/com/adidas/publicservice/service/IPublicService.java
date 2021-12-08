package com.adidas.publicservice.service;

import com.adidas.publicservice.dto.Subscription;

import java.util.List;

public interface IPublicService {
    Subscription create(Subscription subscription);

    boolean cancel(long id);

    List<Subscription> list();

    Subscription get(long id);
}
