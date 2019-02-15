package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.OrderViewModel;
import com.netcracker.edu.fapi.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderDataController {

    private OrderDataService orderDataService;

    @Autowired
    public OrderDataController(OrderDataService orderDataService) {
        this.orderDataService = orderDataService;
    }

    @GetMapping
    public ResponseEntity<List<OrderViewModel>> getAllOrders() {
        return ResponseEntity.ok(orderDataService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<OrderViewModel> saveOrder(@Valid @RequestBody OrderViewModel order) {
        if (order != null && order.getOrderId() == null) {
            Date today = new Date();

            long milliseconds = order.getOrderEndDate().getTime() - today.getTime();
            int days = (int) (milliseconds / (24 * 60 * 60 * 1000)) + 1;

            if (days >= order.getSubscription().getSubMinAmountDays()) {
                order.setOrderStartDate(today);
                order.setOrderPriceInDay(order.getSubscription().getSubPrice());
                order.setOrderStatus("ACTIVE");
                return ResponseEntity.ok(orderDataService.saveOrder(order));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderDataService.deleteOrder(id);
    }

//    @GetMapping(value = "/billing-account/{id}")
//    public ResponseEntity<List<OrderViewModel>> getOrdersByBillingAccount(@PathVariable Long id) {
//        return ResponseEntity.ok(orderDataService.getOrdersByBillingAccount(id));
//    }
//
//    @GetMapping(value = "/user/{id}")
//    public ResponseEntity<List<OrderViewModel>> getOrderByUser(@PathVariable Long id) {
//        return ResponseEntity.ok(orderDataService.getOrdersByUser(id));
//    }
}
