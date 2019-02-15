package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CompanyViewModel;

import java.util.List;

public interface CompanyDataService {
    List<CompanyViewModel> getAllCompanies();

    CompanyViewModel getCompany(Long id);

    CompanyViewModel saveCompany(CompanyViewModel company);

    void deleteCompany(Long id);
}
