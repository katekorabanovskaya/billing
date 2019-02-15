package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import com.netcracker.edu.fapi.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/billing-accounts")
public class BillingAccountDataController {

    private BillingAccountDataService billingAccountDataService;

    @Autowired
    public BillingAccountDataController(BillingAccountDataService billingAccountDataService) {
        this.billingAccountDataService = billingAccountDataService;
    }

    @GetMapping
    public ResponseEntity<List<BillingAccountViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(billingAccountDataService.getAllBillingAccounts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BillingAccountViewModel> getBillingAccount(@PathVariable Long id) {
        BillingAccountViewModel account = billingAccountDataService.getBillingAccount(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BillingAccountViewModel> saveBillingAccount(@Valid @RequestBody BillingAccountViewModel account) {
        if (account != null && account.getBaId() == null) {
            account.setBaAccount(100.0);
            account.setBaMaxDebt(0.0);
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(account));
        }
        return ResponseEntity.badRequest().build();
    }

//    @PostMapping(value = "/add/{id}")
//    public void addAccount(@PathVariable Long id, @RequestBody Double summ) {
//        BillingAccountViewModel account = billingAccountDataService.getBillingAccount(id);
//        if(account != null && summ > 0) {
//            account.setBaAccount(account.getBaAccount() + summ);
//            billingAccountDataService.saveBillingAccount(account);
//        }
//    }

    @DeleteMapping(value = "/{id}")
    public void deleteBillingAccount(@PathVariable Long id) {
        billingAccountDataService.deleteBillingAccount(id);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<List<BillingAccountViewModel>> getUserBillingAccounts(@PathVariable Long id) {
        return ResponseEntity.ok(billingAccountDataService.getUserBillingAccounts(id));
    }
}
