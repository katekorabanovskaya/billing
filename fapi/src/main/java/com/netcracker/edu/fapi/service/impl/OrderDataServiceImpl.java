package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.OrderViewModel;
import com.netcracker.edu.fapi.service.OrderDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<OrderViewModel> getAllOrders() {
        RestTemplate template = new RestTemplate();
        OrderViewModel[] orders = template.getForObject(
                backendServerUrl + "api/orders",
                OrderViewModel[].class
        );
        return orders == null ? Collections.emptyList() : Arrays.asList(orders);
    }

    @Override
    public OrderViewModel getOrder(Long id) {
        return null;
    }

    @Override
    public OrderViewModel saveOrder(OrderViewModel order) {
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/orders",
                order,
                OrderViewModel.class
        ).getBody();
    }

    @Override
    public void deleteOrder(Long id) {
        RestTemplate template = new RestTemplate();
        template.delete(
                backendServerUrl + "api/orders/" + id
        );
    }

    @Override
    public List<OrderViewModel> getOrdersByBillingAccount(Long id) {
        RestTemplate template = new RestTemplate();
        OrderViewModel[] orders = template.getForObject(
                backendServerUrl + "api/orders/billing-account/" + id,
                OrderViewModel[].class
        );
        return orders == null ? Collections.emptyList() : Arrays.asList(orders);
    }

    @Override
    public List<OrderViewModel> getOrdersByUser(Long id) {
        RestTemplate template = new RestTemplate();
        OrderViewModel[] orders = template.getForObject(
                backendServerUrl + "api/orders/user/" + id,
                OrderViewModel[].class
        );
        return orders == null ? Collections.emptyList() : Arrays.asList(orders);
    }
}
