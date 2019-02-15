package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "billing_account", schema = "eduproject")
public class BillingAccount {

    private Long baId;
    private String baNumber;
    private Double baAccount;
    private Double baMaxDebt;
    private Long accountId;
    private Set<Order> orders = new HashSet<>(0);

    public BillingAccount() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ba_id", nullable = false)
    public Long getBaId() {
        return baId;
    }

    public void setBaId(Long baId) {
        this.baId = baId;
    }

    @Column(name = "ba_number", nullable = false, length = 45)
    public String getBaNumber() {
        return baNumber;
    }

    public void setBaNumber(String baNumber) {
        this.baNumber = baNumber;
    }

    @Column(name = "ba_account", precision = 0)
    public Double getBaAccount() {
        return baAccount;
    }

    public void setBaAccount(Double baAccount) {
        this.baAccount = baAccount;
    }

    @Column(name = "ba_max_debt", precision = 0)
    public Double getBaMaxDebt() {
        return baMaxDebt;
    }

    public void setBaMaxDebt(Double baMaxDebt) {
        this.baMaxDebt = baMaxDebt;
    }

    @Column(name = "account_id", nullable = false)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long userId) {
        this.accountId = userId;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_account_id")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Double addAccount(Double sum) {
        Double delta = baAccount + baMaxDebt + sum;

        if (delta >= 0) {
            baAccount += sum;
        }
        return delta;
    }
}

