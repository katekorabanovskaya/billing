package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.entity.enums.Status;
import com.netcracker.edu.backend.repository.OrderRepository;
import com.netcracker.edu.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> getOrder(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Order> getOrdersByBillingAccount(Long id) {
        return repository.getOrdersByBillingAccountId(id);
    }

    @Override
    public Iterable<Order> getActiveOrders() {
        return repository.getActiveOrders();
    }

    //    @Override
//    public Iterable<Order> getOrdersByUserId(Long id) {
//        return repository.getOrdersByUserId(id);
//    }
}
