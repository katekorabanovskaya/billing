package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionDataController {

    private SubscriptionDataService service;

    @Autowired
    public SubscriptionDataController(SubscriptionDataService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionViewModel>> getAllCompanySubscriptions() {
        return ResponseEntity.ok(service.getAllSubscriptions());
    }

    @PostMapping
    public ResponseEntity<SubscriptionViewModel> saveCompanySubscription(
            @Valid @RequestBody SubscriptionViewModel subscription) {
        if (subscription != null) {
            return ResponseEntity.ok(service.saveSubscription(subscription));
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCompanySubscription(@PathVariable Long id) {
        service.deleteSubscription(id);
    }


    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<SubscriptionViewModel>> getUserSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserSubscriptions(id));
    }

    @GetMapping(value = "/count")
    public Long getCountSubscriptions() {
        return service.getCountSubscriptions();
    }

    @GetMapping(value = "/pattern/{pattern}")
    public ResponseEntity<List<String>> getPatternName(@PathVariable String pattern) {
        if (pattern != null) {
            return ResponseEntity.ok(service.getPatternNames(pattern));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/page/{page}/{size}")
    public  ResponseEntity<List<SubscriptionViewModel>> getPageSubscriptions(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @RequestParam(defaultValue = "") String pattern,
            @RequestParam(defaultValue = "") String category) {
        if (page >= 0 && size > 0) {
            return ResponseEntity.ok(service.getPageSubscriptions(page, size, pattern, category));
        }
        return ResponseEntity.badRequest().build();
    }
}
