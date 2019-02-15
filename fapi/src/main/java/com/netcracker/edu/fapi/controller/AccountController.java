package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AccountViewModel;
import com.netcracker.edu.fapi.service.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private AccountDataService accountDataService;

    @Autowired
    public AccountController(AccountDataService accountDataService) {
        this.accountDataService = accountDataService;
    }

    @GetMapping
    public ResponseEntity<List<AccountViewModel>> getAllAccounts() {
        return ResponseEntity.ok(accountDataService.getAllAccounts());
    }

    @GetMapping(value = "/login/{login}")
    public ResponseEntity<AccountViewModel> getAccount(@PathVariable(name = "login") String login) {
        AccountViewModel account = accountDataService.getAccountByLogin(login);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<AccountViewModel> saveAccount(@Valid @RequestBody AccountViewModel account) {
        if (account.getAccountId() == null) {
            account.setRegistrationDate(new Date());
            if (account.getCompany() != null) {
                account.getUser().setRole("ROLE_COMPANY");
            } else {
                account.getUser().setRole("ROLE_USER");
            }
        }
        return ResponseEntity.ok(accountDataService.saveAccount(account));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable(name = "id") Long id) {
        accountDataService.deleteAccount(id);
    }
}
