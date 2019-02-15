package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.repository.SubscriptionRepository;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository repository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public Optional<Subscription> getSubscription(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Subscription> getAllSubscriptions() {
        return repository.findAll();
    }

    @Override
    public void deleteSubscription(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Subscription> getUserSubscriptions(Long ownerId) {
        return repository.getSubscriptionByCompany_CompanyId(ownerId);
    }

    @Override
    public Long getCountSubscriptions() {
        return repository.count();
    }

    @Override
    public Iterable<String> getPatternNames(String pattern) {
        return repository.getPatternNames(pattern);
    }

    @Override
    public Page<Subscription> getPageSubscriptions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Subscription> getPageSubscriptions(String name, Pageable pageable) {
        return repository.getSubscriptionsBySubNameLike(name, pageable);
    }

    @Override
    public Page<Subscription> getPageSubscriptions(String subName, String categoryName, Pageable pageable) {
        return repository.getSubscriptionsBySubNameLikeAndCategory_CategoryName(subName, categoryName, pageable);
    }
}
