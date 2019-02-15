package com.netcracker.edu.backend.entity;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "subscription", schema = "eduproject")
public class Subscription {

    private Long subId;
    private String subName;
    private Double subPrice;
    private Integer subMinAmountDays;
    private String subUrl;
    private String subInformation;
    private String subImage;
    private Company company;
    private Category category;

    public Subscription() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    @Column(name = "sub_name", nullable = false, length = 45)
    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName.toLowerCase();
    }

    @Column(name = "sub_price", nullable = false, precision = 0)
    public Double getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Double subPrice) {
        this.subPrice = subPrice;
    }

    @Column(name = "sub_min_amount_days", nullable = false)
    public Integer getSubMinAmountDays() {
        return subMinAmountDays;
    }

    public void setSubMinAmountDays(Integer subMinAmountDays) {
        this.subMinAmountDays = subMinAmountDays;
    }

    @Column(name = "sub_url", nullable = true, length = 200)
    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }

    @Column(name = "sub_information", nullable = true, length = 100)
    public String getSubInformation() {
        return subInformation;
    }

    public void setSubInformation(String subInformation) {
        this.subInformation = subInformation;
    }

    @Column(name = "sub_image", nullable = true, length = 60)
    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
