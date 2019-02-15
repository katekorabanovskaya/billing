package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.OrderViewModel;

import java.util.List;

public interface OrderDataService {
    List<OrderViewModel> getAllOrders();

    OrderViewModel getOrder(Long id);

    OrderViewModel saveOrder(OrderViewModel order);

    void deleteOrder(Long id);

    List<OrderViewModel> getOrdersByBillingAccount(Long id);

    List<OrderViewModel> getOrdersByUser(Long id);

}
