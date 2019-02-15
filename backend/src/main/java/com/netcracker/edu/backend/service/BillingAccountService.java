package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.BillingAccount;

import java.util.Optional;

public interface BillingAccountService {

    Iterable<BillingAccount> getAllBillingAccounts();

    Optional<BillingAccount> getBillingAccount(Long id);

    BillingAccount saveBillingAccount(BillingAccount account);

    void deleteBillingAccount(Long id);

    Iterable<BillingAccount> getUserBillingAccounts(Long id);
}
