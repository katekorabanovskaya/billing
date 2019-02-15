package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Order;

import java.util.Optional;

public interface OrderService {

    Iterable<Order> getAllOrders();

    Optional<Order> getOrder(Long id);

    Order saveOrder(Order order);

    void deleteOrder(Long id);

    Iterable<Order> getOrdersByBillingAccount(Long id);

    Iterable<Order> getActiveOrders();

//    Iterable<Order> getOrdersByUserId(Long id);
}
