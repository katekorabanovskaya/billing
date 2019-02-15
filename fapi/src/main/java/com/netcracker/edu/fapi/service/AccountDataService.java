package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.AccountViewModel;

import java.util.List;

public interface AccountDataService {
    List<AccountViewModel> getAllAccounts();

    AccountViewModel getAccountByLogin(String login);

    AccountViewModel saveAccount(AccountViewModel account);

    void deleteAccount(Long id);
}
