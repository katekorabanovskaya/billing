package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private SubscriptionService service;

    @Autowired
    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getSubscription(@PathVariable(name = "id") Long id) {

        Optional<Subscription> subscription = service.getSubscription(id);

        if(subscription.isPresent()) {
            return ResponseEntity.ok(subscription.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Subscription> getAllSubscriptions() {
        return service.getAllSubscriptions();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        return service.saveSubscription(subscription);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubscription(@PathVariable(name = "id") Long id) {
        service.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Iterable<Subscription> getUserSubscriptions(@PathVariable(name = "id") Long id) {
        return service.getUserSubscriptions(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long getCountSubscriptions() {
        return service.getCountSubscriptions();
    }

    @RequestMapping(value = "/pattern/{pattern}", method = RequestMethod.GET)
    public Iterable<String> getPatternNames(@PathVariable String pattern) {
        return service.getPatternNames(pattern.toLowerCase());
    }

    @RequestMapping(value = "/page/{page}/{size}", method = RequestMethod.GET)
    public List<Subscription> getPageSubscriptions(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @RequestParam(defaultValue = "") String pattern,
            @RequestParam(defaultValue = "") String category) {

        PageRequest pageRequest = PageRequest.of(page, size);

        if(!pattern.isEmpty()) {
            pattern = "%" + pattern + "%";
        }

        if(!pattern.isEmpty() && !category.isEmpty()) {
            return service.getPageSubscriptions(pattern, category, pageRequest).getContent();
        } else if(!pattern.isEmpty()) {
            return service.getPageSubscriptions(pattern, pageRequest).getContent();
        } else {
            return service.getPageSubscriptions(pageRequest).getContent();
        }
    }

}
