package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountViewModel {

    private Long accountId;
    @NotNull
    @NotEmpty
    @Size(max = 45)
    private String username;
    @NotNull
    @NotEmpty @Size(max = 45)
    private String lastName;
    @NotNull
    @NotEmpty @Size(max = 45)
    private String firstName;
    private Date birthdayDate;
    private Date registrationDate;

    @NotNull
    @Valid
    private UserViewModel user;

    private CompanyViewModel company;

    private Set<BillingAccountViewModel> billingAccounts;

    public AccountViewModel() {

    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public CompanyViewModel getCompany() {
        return company;
    }

    public void setCompany(CompanyViewModel company) {
        this.company = company;
    }

    public Set<BillingAccountViewModel> getBillingAccounts() {
        return billingAccounts;
    }

    public void setBillingAccounts(Set<BillingAccountViewModel> billingAccounts) {
        this.billingAccounts = billingAccounts;
    }
}
