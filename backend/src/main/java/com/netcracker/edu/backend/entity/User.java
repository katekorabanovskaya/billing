package com.netcracker.edu.backend.entity;

import com.netcracker.edu.backend.entity.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(
        name = "user",
        schema = "eduproject",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_login"})}
)
public class User {

    private Long userId;
    private String login;
    private String password;
    private Role role;
    private Account account;

    public User() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NotNull
    @Email @Size(max = 145)
    @Column(name = "user_login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String userLogin) {
        this.login = userLogin;
    }

    @NotNull
    @Size(max = 145)
    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "user_role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(mappedBy = "user")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

