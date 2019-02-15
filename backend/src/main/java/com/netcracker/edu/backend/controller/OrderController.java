package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.entity.enums.Status;
import com.netcracker.edu.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id") Long id) {
        Optional<Order> order = service.getOrder(id);

        if(order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order saveOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable(name = "id") Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/billing-account/{id}", method = RequestMethod.GET)
    public Iterable<Order> getOrdersByBillingAccount(@PathVariable(name = "id") Long id) {
        return service.getOrdersByBillingAccount(id);
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public Iterable<Order> getOrderByUser(@PathVariable(name = "id") Long id) {
//        return service.getOrdersByUserId(id);
//    }
}
