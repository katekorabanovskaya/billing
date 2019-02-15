package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.entity.enums.Status;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class LogicService {

    private BillingAccountService billingAccountService;

    @Autowired
    public LogicService(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @Scheduled(cron = "${logic.cron}")
    public void service() {

        Date today = new Date();

        billingAccountService.getAllBillingAccounts().forEach((ba) -> {
            Double delta;
            for (Order order : ba.getOrders()) {

                if (order.getOrderStatus() == Status.ACTIVE) {

                    if (today.after(order.getOrderEndDate())) {
                        System.out.println(String.format("BA id: %3d Order id: %3d Operation: %10s",
                                ba.getBaId(),
                                order.getOrderId(),
                                "COMPLITED"));
                        order.setOrderStatus(Status.COMPLITED);
                    } else {
                        delta = ba.addAccount(-order.getOrderPriceInDay());
                        if (delta >= 0) {
                            System.out.println(String.format(
                                    "BA id: %3d Order id: %3d Operation: %10s Price: %4.2f Account: %5.2f",
                                    ba.getBaId(),
                                    order.getOrderId(),
                                    "PAYMENT",
                                    order.getOrderPriceInDay(),
                                    delta));
                        } else {
                            System.out.println(String.format("BA id: %3d Order id: %3d Operation: %10s Price: %4.2f Account: %5.2f",
                                    ba.getBaId(),
                                    order.getOrderId(),
                                    "SUSPENDED",
                                    order.getOrderPriceInDay(),
                                    delta));
                            order.setOrderStatus(Status.SUSPENDED);
                        }
                    }
                }
            }
            billingAccountService.saveBillingAccount(ba);
        });
    }
}
