package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company", schema = "eduproject")
public class Company {

    private Long companyId;
    private String companyName;
    private String companyDomainName;
    private Set<Subscription> subscriptions = new HashSet<>(0);

    public Company() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Column(name = "company_name", nullable = false, length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "company_domain_name", nullable = false, length = 60)
    public String getCompanyDomainName() {
        return companyDomainName;
    }

    public void setCompanyDomainName(String companyDomainName) {
        this.companyDomainName = companyDomainName;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
