package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionViewModel {

    private Long subId;
    @NotNull
    @NotEmpty @Size(max = 45)
    private String subName;
    @NotNull
    @PositiveOrZero
    private Double subPrice;
    @PositiveOrZero
    private Integer subMinAmountDays;
    @Size(max = 200)
    private String subUrl;
    @Size(max = 100)
    private String subInformation;
    @Size(max = 60)
    private String subImage;

    @NotNull
    @Valid
    private CompanyViewModel company;

    @Valid
    private CategoryViewModel category;

    public SubscriptionViewModel() {
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Double getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Double subPrice) {
        this.subPrice = subPrice;
    }

    public Integer getSubMinAmountDays() {
        return subMinAmountDays;
    }

    public void setSubMinAmountDays(Integer subMinAmountDays) {
        this.subMinAmountDays = subMinAmountDays;
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }

    public String getSubInformation() {
        return subInformation;
    }

    public void setSubInformation(String subInformation) {
        this.subInformation = subInformation;
    }

    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    public CompanyViewModel getCompany() {
        return company;
    }

    public void setCompany(CompanyViewModel company) {
        this.company = company;
    }

    public CategoryViewModel getCategory() {
        return category;
    }

    public void setCategory(CategoryViewModel category) {
        this.category = category;
    }
}
