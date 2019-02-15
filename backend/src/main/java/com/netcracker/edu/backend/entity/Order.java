package com.netcracker.edu.backend.entity;

import com.netcracker.edu.backend.entity.enums.Status;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sub_order", schema = "eduproject")
public class Order {

    private Long orderId;
    private Status orderStatus;
    private Double orderPriceInDay;
    private Date orderStartDate;
    private Date orderEndDate;
    private Subscription subscription;
    private Long billingAccountId;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "order_status", nullable = false, length = 45)
    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "order_price_in_day", nullable = false)
    public Double getOrderPriceInDay() {
        return orderPriceInDay;
    }

    public void setOrderPriceInDay(Double orderPriceInDay) {
        this.orderPriceInDay = orderPriceInDay;
    }

    @Column(name = "order_start_date", nullable = false)
    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    @Column(name = "order_end_date", nullable = false)
    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date amountDays) {
        this.orderEndDate = amountDays;
    }

    @Column(name = "billing_account_id", nullable = false)
    public Long getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(Long billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "sub_id", nullable = false)
    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

}
