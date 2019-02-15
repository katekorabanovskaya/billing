package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CompanyViewModel;
import com.netcracker.edu.fapi.service.CompanyDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CompanyDataServiceImpl implements CompanyDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<CompanyViewModel> getAllCompanies() {
        RestTemplate template = new RestTemplate();
        CompanyViewModel[] companies = template.getForObject(
                backendServerUrl + "api/companies",
                CompanyViewModel[].class
        );
        return companies == null ? Collections.emptyList() : Arrays.asList(companies);
    }

    @Override
    public CompanyViewModel getCompany(Long id) {
        return null;
    }

    @Override
    public CompanyViewModel saveCompany(CompanyViewModel company) {
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/companies",
                company,
                CompanyViewModel.class
        ).getBody();
    }

    @Override
    public void deleteCompany(Long id) {
        RestTemplate template = new RestTemplate();
        template.delete(
                backendServerUrl + "api/companies/" + id
        );
    }
}
