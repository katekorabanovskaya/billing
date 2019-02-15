package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubscriptionViewModel;

import java.util.List;

public interface SubscriptionDataService {
    List<SubscriptionViewModel> getAllSubscriptions();

    SubscriptionViewModel saveSubscription(SubscriptionViewModel subscription);

    void deleteSubscription(Long id);

    List<SubscriptionViewModel> getUserSubscriptions(Long id);

    Long getCountSubscriptions();

    List<String> getPatternNames(String pattern);

    List<SubscriptionViewModel> getPageSubscriptions(Integer page, Integer size, String pattern, String category);

}
