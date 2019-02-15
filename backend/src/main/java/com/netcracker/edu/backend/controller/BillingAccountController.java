package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/billing-accounts")
public class BillingAccountController {

    private BillingAccountService service;

    @Autowired
    public BillingAccountController(BillingAccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAllBillingAccounts() {
        return service.getAllBillingAccounts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getBillingAccount(@PathVariable(name = "id") Long id) {
        Optional<BillingAccount> account = service.getBillingAccount(id);

        if(account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public BillingAccount saveBillingAccount(@RequestBody BillingAccount account) {
        return service.saveBillingAccount(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBillingAccount(@PathVariable(name = "id") Long id) {
        service.deleteBillingAccount(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Iterable<BillingAccount> getUserBillingAccount(@PathVariable(name = "id") Long id) {
        return service.getUserBillingAccounts(id);
    }

}
