package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Account;

import java.util.Optional;

public interface AccountService {

    Iterable<Account> getAllAccounts();

    Optional<Account> getAccountByLogin(String login);

    Account saveAccount(Account account);

    void deleteAccount(Long id);
}
