package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.AccountViewModel;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountDataServiceImpl implements AccountDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public AccountDataServiceImpl(BCryptPasswordEncoder bcryptEncoder) {
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public List<AccountViewModel> getAllAccounts() {
        RestTemplate template = new RestTemplate();
        AccountViewModel[] accounts = template.getForObject(
                backendServerUrl + "api/accounts",
                AccountViewModel[].class
        );
        return accounts == null ? Collections.emptyList() : Arrays.asList(accounts);
    }

    @Override
    public AccountViewModel getAccountByLogin(String login) {
        return new RestTemplate().getForEntity(
                backendServerUrl + "api/accounts/login/" + login,
                AccountViewModel.class
        ).getBody();
    }

    @Override
    public AccountViewModel saveAccount(AccountViewModel account) {
        UserViewModel user = account.getUser();
        if(user != null) {
            user.setPassword(bcryptEncoder.encode(user.getPassword()));
        }
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/accounts",
                account,
                AccountViewModel.class
        ).getBody();
    }

    @Override
    public void deleteAccount(Long id) {
        new RestTemplate().delete(
                backendServerUrl + "api/accounts/" + id
        );
    }
}
