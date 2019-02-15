package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.BillingAccountViewModel;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAllBillingAccounts();

    BillingAccountViewModel getBillingAccount(Long id);

    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);

    void deleteBillingAccount(Long id);

    List<BillingAccountViewModel> getUserBillingAccounts(Long id);
}
