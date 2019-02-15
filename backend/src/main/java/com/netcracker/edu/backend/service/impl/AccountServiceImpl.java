package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Account;
import com.netcracker.edu.backend.repository.AccountRepository;
import com.netcracker.edu.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Account> getAllAccounts() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> getAccountByLogin(String login) {
        return repository.findByUser_Login(login);
    }

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
