package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface SubscriptionService {

    Iterable<Subscription> getAllSubscriptions();

    Optional<Subscription> getSubscription(Long id);

    Subscription saveSubscription(Subscription subscription);

    void deleteSubscription(Long id);

    Iterable<Subscription> getUserSubscriptions(Long ownerId);

    Long getCountSubscriptions();

    Iterable<String> getPatternNames(String pattern);


    Page<Subscription> getPageSubscriptions(Pageable pageable);

    Page<Subscription> getPageSubscriptions(String name, Pageable pageable);

    Page<Subscription> getPageSubscriptions(String subName, String categoryName, Pageable pageable);
}
