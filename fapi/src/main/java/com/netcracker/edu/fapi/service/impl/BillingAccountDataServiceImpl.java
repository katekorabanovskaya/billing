package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import com.netcracker.edu.fapi.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BillingAccountDataServiceImpl implements BillingAccountDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<BillingAccountViewModel> getAllBillingAccounts() {
        RestTemplate template = new RestTemplate();
        BillingAccountViewModel[] billings = template.getForObject(
                backendServerUrl + "api/billing-accounts",
                BillingAccountViewModel[].class
        );
        return billings == null ? Collections.emptyList() : Arrays.asList(billings);
    }

    @Override
    public BillingAccountViewModel getBillingAccount(Long id) {
        return new RestTemplate().getForEntity(
                backendServerUrl + "api/billing-accounts/" + id,
                BillingAccountViewModel.class
        ).getBody();
    }

    @Override
    public BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account) {
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/billing-accounts",
                account,
                BillingAccountViewModel.class
        ).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate template = new RestTemplate();
        template.delete(
                backendServerUrl + "api/billing-accounts/" + id
        );
    }

    @Override
    public List<BillingAccountViewModel> getUserBillingAccounts(Long id) {
        RestTemplate template = new RestTemplate();
        BillingAccountViewModel[] billings = template.getForObject(
          backendServerUrl + "api/billing-accounts/user/" + id,
          BillingAccountViewModel[].class
        );
        return billings == null ? Collections.emptyList() : Arrays.asList(billings);
    }
}
