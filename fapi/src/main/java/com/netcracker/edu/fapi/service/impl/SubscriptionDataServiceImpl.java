package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<SubscriptionViewModel> getAllSubscriptions() {
        RestTemplate template = new RestTemplate();
        SubscriptionViewModel[] subscriptions = template.getForObject(
                backendServerUrl + "/api/subscriptions/",
                SubscriptionViewModel[].class);
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    @Override
    public SubscriptionViewModel saveSubscription(SubscriptionViewModel subscription) {
        return new RestTemplate().postForEntity(
                backendServerUrl + "/api/subscriptions",
                subscription,
                SubscriptionViewModel.class).getBody();
    }

    @Override
    public void deleteSubscription(Long id) {
        RestTemplate template = new RestTemplate();
        template.delete(
                backendServerUrl + "/api/subscriptions/" + id
        );
    }

    @Override
    public List<SubscriptionViewModel> getUserSubscriptions(Long id) {
        RestTemplate template = new RestTemplate();
        SubscriptionViewModel[] subscriptions = template.getForObject(
                backendServerUrl + "/api/subscriptions/user/" + id,
                SubscriptionViewModel[].class
        );
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }

    @Override
    public Long getCountSubscriptions() {
        return new RestTemplate().getForObject(
                backendServerUrl + "api/subscriptions/count",
                Long.class
        );
    }

    @Override
    public List<String> getPatternNames(String pattern) {
        RestTemplate template = new RestTemplate();
        String[] names = template.getForObject(
                backendServerUrl + "/api/subscriptions/pattern/" + pattern,
                String[].class
        );
        return names == null ? Collections.emptyList() : Arrays.asList(names);
    }

    @Override
    public List<SubscriptionViewModel> getPageSubscriptions(Integer page, Integer size, String pattern, String category) {
        RestTemplate template = new RestTemplate();
        String url = backendServerUrl + "/api/subscriptions/page/" + page + "/" + size;

        if(!pattern.isEmpty() || !category.isEmpty()) {
            url += "?";
        }

        if(!pattern.isEmpty()) {
            url += "pattern=" + pattern;
        }
        if(!category.isEmpty()) {
            url += "&category=" + category;
        }

        SubscriptionViewModel[] subscriptions = template.getForObject(
                url,
                SubscriptionViewModel[].class
        );
        return subscriptions == null ? Collections.emptyList() : Arrays.asList(subscriptions);
    }
}


